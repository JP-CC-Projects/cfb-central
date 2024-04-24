// src/components/common/header/Header.tsx
import { useSelector } from 'react-redux';
import { useLocation } from 'react-router-dom';
import { RootState } from '../../../redux/store';
import { useEffect, useState } from 'react';
import { contrastUtils } from '../../../utils/isContrastReadable';
import mainLogoText from '../../../assets/mainlogotext.png'

const Footer = () => {
    const teamDetails = useSelector((state: RootState) => state.team.teamDetails);
    const location = useLocation();
    const [bgColor, setBgColor] = useState('');

    useEffect(() => {
        if (location.pathname.startsWith('/')) {
            let newBgColor = '';
            if (teamDetails?.color) {
                const isReadable = contrastUtils.isContrastReadable(teamDetails.color, '#FFFFFF');
                if (isReadable) {
                    newBgColor = teamDetails.color;
                } else if (teamDetails.altColor) {
                    const isAltReadable = contrastUtils.isContrastReadable(teamDetails.altColor, '#FFFFFF');
                    if (isAltReadable) {
                        newBgColor = teamDetails.altColor;
                    }
                }
            }
            setBgColor(newBgColor);
        } else {
            setBgColor('#1F2937'); // Default color if no colors are readable
        }
    }, [location, teamDetails]);

    return (
        // <nav style={{ backgroundColor: bgColor }} className="text-white p-4 relative">

        <nav style={{ backgroundColor: bgColor, position: 'fixed', bottom: 0, width: '100%', height: '4vh', zIndex: 3000 }} className="footer-nav opacity-80">
            <div style={{height: '5vh'}}>
                <img src={mainLogoText}></img>
            </div>
        </nav>
    );
};

export default Footer;
