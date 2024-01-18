// TimelineReactNodeMaker.tsx
import React from 'react';
import { TeamTimeline } from '../../../../../types/teamTypes';
import styles from './TimelineReactNodeMaker.module.css';

const TimelineReactNodeMaker: React.FC<TeamTimeline> = ({ cardTitle, url, quarterScores, media }) => {
    return (
        <div>
            <div className={styles.timelineWrapper}>
            <h1 className="text-xl font-bold text-center">{cardTitle}</h1>
                <img src={media.source.url} style={{ width: '50vw', maxHeight: '25vh', objectFit: 'cover' }}></img>

                <a href={url} 
                   target="_blank" 
                   rel="noopener noreferrer" 
                   className={styles.customLink}>
                    Test Link Here
                </a>
                <table className={styles.scoreTable}>
    <thead>
        <tr>
            <th></th>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            {/* Conditionally render OT headers */}
            {typeof quarterScores.ot1HomeTeamScore === 'number' ? <th>OT</th> : null}
            {typeof quarterScores.ot2HomeTeamScore === 'number' ? <th>OT2</th> : null}
            {typeof quarterScores.ot3HomeTeamScore === 'number' ? <th>OT3</th> : null}
            <th>T</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Away</td>
            <td>{quarterScores.q1AwayTeamPointsScored}</td>
            <td>{quarterScores.q2AwayTeamPointsScored}</td>
            <td>{quarterScores.q3AwayTeamPointsScored}</td>
            <td>{quarterScores.q4AwayTeamPointsScored}</td>
            {/* Conditionally render OT scores */}
            {typeof quarterScores.ot1AwayTeamScore === 'number' ? <td>{quarterScores.ot1AwayTeamPointsScored}</td> : null}
            {typeof quarterScores.ot2AwayTeamScore === 'number' ? <td>{quarterScores.ot2AwayTeamPointsScored}</td> : null}
            {typeof quarterScores.ot3AwayTeamScore === 'number' ? <td>{quarterScores.ot3AwayTeamPointsScored}</td> : null}
            <td>{
                // Determine final score
                typeof quarterScores.ot3AwayTeamScore === 'number' ? quarterScores.ot3AwayTeamScore :
                typeof quarterScores.ot2AwayTeamScore === 'number' ? quarterScores.ot2AwayTeamScore :
                typeof quarterScores.ot1AwayTeamScore === 'number' ? quarterScores.ot1AwayTeamScore :
                quarterScores.q4AwayTeamScore
            }</td>
        </tr>
        <tr>
            <td>Home</td>
            <td>{quarterScores.q1HomeTeamPointsScored}</td>
            <td>{quarterScores.q2HomeTeamPointsScored}</td>
            <td>{quarterScores.q3HomeTeamPointsScored}</td>
            <td>{quarterScores.q4HomeTeamPointsScored}</td>
            {/* Conditionally render OT scores */}
            {typeof quarterScores.ot1HomeTeamScore === 'number' ? <td>{quarterScores.ot1HomeTeamPointsScored}</td> : null}
            {typeof quarterScores.ot2HomeTeamScore === 'number' ? <td>{quarterScores.ot2HomeTeamPointsScored}</td> : null}
            {typeof quarterScores.ot3HomeTeamScore === 'number' ? <td>{quarterScores.ot3HomeTeamPointsScored}</td> : null}
            <td>{
                // Determine final score
                typeof quarterScores.ot3HomeTeamScore === 'number' ? quarterScores.ot3HomeTeamScore :
                typeof quarterScores.ot2HomeTeamScore === 'number' ? quarterScores.ot2HomeTeamScore :
                typeof quarterScores.ot1HomeTeamScore === 'number' ? quarterScores.ot1HomeTeamScore :
                quarterScores.q4HomeTeamScore
            }</td>
        </tr>
    </tbody>
</table>




            </div>
        </div>
    );
};

export default TimelineReactNodeMaker;