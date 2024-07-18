# CFB Central

Automatically generated home page for all 133 Division 1 college football teams, built using Spring and React with Redux, with Vite as the build tool.

## Data Sources

### Football Data
Data from [College Football Data API (CFBD)](https://api.collegefootballdata.com/api/docs/?url=/api-docs.json):

- Data provided by CFBD was highly irregular (snake_case, camelCase, lots of missing data, null values, wrong values, duplicate entries, non-matching column names for dependent tables, and so on) and was normalized using custom configurations within Spring and various correction strategies.
- Game quarter scores were not available via CFBD API and were generated by parsing large amounts of play data from CFBD's `/play` endpoint.
- All data persisted to MySQL database in order to respect CFBD's request of minimizing API calls.

### Images and Maps
- Stadium image URLs collected using Google Custom Search API.
- Team images from ESPN
- Video for splash page created by Al Fu. 
- Player locations plotted using Google Maps API.
- Images belong to respective owners

## UI Components
- Material UI for navigation components.
- Customized fork of React Chrono for Timeline (adjusted spacing).
- Randomized catch-phrase on splash page (I couldn't decided on one)
- Charts.js for charts

## Security
- The website initially had Spring Security for account features, but these features have been removed due to outdated implementation of Spring Security/CVEs and will be replaced.

![image](https://github.com/user-attachments/assets/86435ae8-d1fd-415a-a0cd-bd453cde596e)
![image](https://github.com/user-attachments/assets/e7d4b404-2ce6-4288-a99b-0ed5723bf7e8)
![image](https://github.com/user-attachments/assets/e215d6ab-fe66-44fe-890c-5756530640dc)

