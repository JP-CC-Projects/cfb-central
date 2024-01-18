import { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import type { ThunkDispatch } from 'redux-thunk';
import type { UnknownAction } from 'redux';
import { fetchTeamRoster } from '../../../redux/actions/teamActions';
import { RootState } from '../../../redux/store';
import { GoogleMap, useJsApiLoader, MarkerF, InfoWindowF } from '@react-google-maps/api';
import { Library } from '@googlemaps/js-api-loader';
import markerIcon from './../../../assets/markericon5.svg'; // Import SVG here
import mapStyles from './MapComponentStyle';
import { useState } from 'react';
import { Player } from '../../../types/teamTypes';

// import './MapComponentStyle.css'; 

const apiKey = import.meta.env.VITE_GOOGLE_MAPS_API_KEY || '';


interface TeamRosterProps {
  teamId: number;
  teamSeason: number;
}

const options = {
  styles: mapStyles,
  streetViewControl: false,
  mapTypeControl: false
};

const containerStyle = {
  width: '100%',
  height: '80vh'
};


const center = {
  lat: 38.5,
  lng: -94.5
};

const libraries: Library[] = ['geometry', 'drawing'];

const MapComponent: React.FC<TeamRosterProps> = ({ teamId, teamSeason }) => {
  const dispatch = useDispatch<ThunkDispatch<{}, {}, UnknownAction>>();
  const players = useSelector((state: RootState) => state.team.teamRoster); // Adjust this path to your Redux state structure
  const [selectedPlayer, setSelectedPlayer] = useState<Player | null>(null);
  //Open Info Window:
  const onMarkerClick = (player: Player) => {
    setSelectedPlayer(player);
  };

  //Close Info Window:
  const onInfoWindowClick = () => {
    setSelectedPlayer(null);
  };

  useEffect(() => {
    const cacheKey = `teamRoster-${teamId}-${teamSeason}`;
    const cachedRoster = localStorage.getItem(cacheKey);

    if (cachedRoster) {
      const parsedRoster = JSON.parse(cachedRoster);
      if (parsedRoster.teamId === teamId && parsedRoster.teamSeason === teamSeason) {
        dispatch({ type: 'FETCH_TEAM_ROSTER_SUCCESS', payload: parsedRoster });
      } else {
        dispatch(fetchTeamRoster(teamId, teamSeason));
      }
    } else if (teamId && !isNaN(teamId) && teamSeason) {
      dispatch(fetchTeamRoster(teamId, teamSeason));
    }
  }, [dispatch, teamId, teamSeason]);

  useEffect(() => {
    const cacheKey = `teamRoster-${teamId}-${teamSeason}`;
    if (players.length > 0) {
      localStorage.setItem(cacheKey, JSON.stringify(players));
    }
  }, [players, teamId, teamSeason]);

  const { isLoaded } = useJsApiLoader({
    id: 'google-map-script',
    googleMapsApiKey: apiKey,
    libraries
  });

  if (!isLoaded) return <div>Loading...</div>;

  return (
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={5}
        options={options}
      >
        {players.map((player) => (
          <MarkerF
            key={player.id}
            position={{ lat: player.homeLatitude, lng: player.homeLongitude }}
            onClick={() => onMarkerClick(player)}
            icon={{
              url: markerIcon,
            }}
          />
        ))}

        {selectedPlayer && (
          <InfoWindowF
            options={{ pixelOffset: new window.google.maps.Size(0, -20) }}
            position={{
              lat: selectedPlayer.homeLatitude,
              lng: selectedPlayer.homeLongitude,
            }}
            onCloseClick={onInfoWindowClick}
          >
            <div onClick={onInfoWindowClick}>
              <p>{`#${selectedPlayer.jersey} | ${selectedPlayer.firstName} ${selectedPlayer.lastName} | ${selectedPlayer.position}`}</p>
            </div>
          </InfoWindowF>
        )}
      </GoogleMap>
  );
};

export default MapComponent;