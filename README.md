# PRACTICUM-EXAM
Music Playlist Manager 
## Features
Add up to 4 songs with details:
  - Song title
  - Artist name
  - Rating (1-5 stars)
  - Optional comments
- View complete playlist
- Calculate average song rating
- Clean exit with confirmation
  ## Screens
  ### Main Screen
  ![main screen](https://github.com/user-attachments/assets/7e3e90d7-eb97-49c8-8d40-f74a1e77c90a)

  This is the primary screen of your music playlist app where users can:

Add songs to their playlist (up to 4 songs max)

View their playlist (navigates to a second screen)

Exit the app

### UI Components
Three Buttons (defined in activity_main.xml):

Enter Button (enterButton): Opens a dialog to input song details

Click Button (clickButton): Navigates to the playlist view screen

Exit Button (exitAppButton): Closes the app with confirmation

Data Storage (4 parallel arrays):

titles: Stores song names (e.g., "Burning Blue")

artists: Stores artist names (e.g., "Mariah the Scientist")

ratings: Stores ratings (1-5)

comments: Stores optional user comments

count: Tracks how many songs are currently stored (0-4)
