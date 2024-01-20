import * as React from 'react';
import { request } from './axios_helper';

interface AuthContentProps {
}

export default class AuthContent extends React.Component<AuthContentProps> {
    constructor(props: AuthContentProps) {
        super(props);
        this.state = {
            data: []
        };
    };

    componentDidMount(): void {
        request(
            "GET",
            "/messages", 
            {}
            )
            .then((response) => {
            this.setState({ data: response.data })
        });
    };
    render(){
        return (
            <div>
                {/* {this.state.data && this.state.data.map(
                    (line: string) => <p>{line}</p>
                )} */}
            </div>
        )
    }
}
