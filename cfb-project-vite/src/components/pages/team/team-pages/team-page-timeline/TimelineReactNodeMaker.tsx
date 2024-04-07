// TimelineReactNodeMaker.tsx
import React from 'react';
import { TeamTimeline } from '../../../../../types/teamTypes';
import styles from './TimelineReactNodeMaker.module.css';

const TimelineReactNodeMaker: React.FC<TeamTimeline> = ({ homeTeam, awayTeam, homeTeamAbrv, awayTeamAbrv, quarterScores, media }) => {
    if (!quarterScores) {
        return <div>Score Data Not Available</div>;
    }
    return (
        <div>
            <div className={styles.timelineWrapper}>
                <div>
                    <h1 className="text-xl font-bold text-center">{awayTeam} @ {homeTeam}</h1>
                </div>

                <div>
                    <img src={media.source.url} style={{ width: '50vw', maxHeight: '25vh', objectFit: 'cover' }}></img>
                </div>
                <div style={{ textAlign: 'right' }}>
                    <a href={media.source.url} target="_blank"
                        rel="noopener noreferrer"
                        className={styles.customLink}>
                        (Image Source)
                    </a>
                </div>

                <table className={styles.scoreTable}>
                    <thead>
                        <tr>
                            <th></th>
                            <th>1</th>
                            <th>2</th>
                            <th>3</th>
                            <th>4</th>
                            {/* Conditionally render OT headers */}
                            {quarterScores?.ot1HomeTeamScore !== null && <th>OT</th>}
                            {quarterScores?.ot2HomeTeamScore !== null && <th>OT2</th>}
                            {quarterScores?.ot3HomeTeamScore !== null && <th>OT3</th>}
                            <th>T</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>{awayTeamAbrv}</td>
                            <td>{quarterScores.q1AwayTeamPointsScored}</td>
                            <td>{quarterScores.q2AwayTeamPointsScored}</td>
                            <td>{quarterScores.q3AwayTeamPointsScored}</td>
                            <td>{quarterScores.q4AwayTeamPointsScored}</td>
                            {/* Conditionally render OT scores */}
                            {quarterScores.ot1AwayTeamScore !== null && typeof quarterScores.ot1AwayTeamScore === 'number' ? <td>{quarterScores.ot1AwayTeamPointsScored}</td> : null}
                            {quarterScores.ot2AwayTeamScore !== null && typeof quarterScores.ot2AwayTeamScore === 'number' ? <td>{quarterScores.ot2AwayTeamPointsScored}</td> : null}
                            {quarterScores.ot3AwayTeamScore !== null && typeof quarterScores.ot3AwayTeamScore === 'number' ? <td>{quarterScores.ot3AwayTeamPointsScored}</td> : null}
                            <td>{
                                // Determine final score
                                typeof quarterScores.ot3AwayTeamScore === 'number' ? quarterScores.ot3AwayTeamScore :
                                    typeof quarterScores.ot2AwayTeamScore === 'number' ? quarterScores.ot2AwayTeamScore :
                                        typeof quarterScores.ot1AwayTeamScore === 'number' ? quarterScores.ot1AwayTeamScore :
                                            quarterScores.q4AwayTeamScore
                            }</td>
                        </tr>
                        <tr>
                            <td>{homeTeamAbrv}</td>
                            <td>{quarterScores.q1HomeTeamPointsScored}</td>
                            <td>{quarterScores.q2HomeTeamPointsScored}</td>
                            <td>{quarterScores.q3HomeTeamPointsScored}</td>
                            <td>{quarterScores.q4HomeTeamPointsScored}</td>
                            {/* Conditionally render OT scores */}
                            {quarterScores.ot1HomeTeamScore !== null && typeof quarterScores.ot1HomeTeamScore === 'number' ? <td>{quarterScores.ot1HomeTeamPointsScored}</td> : null}
                            {quarterScores.ot2HomeTeamScore !== null && typeof quarterScores.ot2HomeTeamScore === 'number' ? <td>{quarterScores.ot2HomeTeamPointsScored}</td> : null}
                            {quarterScores.ot3HomeTeamScore !== null && typeof quarterScores.ot3HomeTeamScore === 'number' ? <td>{quarterScores.ot3HomeTeamPointsScored}</td> : null}
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