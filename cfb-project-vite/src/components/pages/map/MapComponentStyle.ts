const mapStyles = [
    { elementType: "geometry", stylers: [{ color: "#1d2c4d" }] }, // Deep blue background color
    // Labels have visibility off by default
    { elementType: "labels", stylers: [{ visibility: "off" }] },
    // Enable and style labels for localities and roads with fill and stroke
    {
        featureType: "administrative.locality",
        elementType: "labels.text.fill",
        stylers: [{ visibility: "on" }, { color: "#8ec3b9" }] // Light blue-green color for text fill
    },
    {
        featureType: "administrative.locality",
        elementType: "labels.text.stroke",
        stylers: [{ visibility: "on" }, { color: "#1a3646" }] // Dark blue color for text stroke
    },
    {
        featureType: "road",
        elementType: "labels.text.fill",
        stylers: [{ visibility: "on" }, { color: "#98a5be" }] // Light blue color for road label text fill
    },
    {
        featureType: "road",
        elementType: "labels.text.stroke",
        stylers: [{ visibility: "on" }, { color: "#1d2c4d" }] // Deep blue color for road label text stroke
    },
    // Hide points of interest
    { featureType: "poi", elementType: "all", stylers: [{ visibility: "off" }] },
    // Hide transit features
    { featureType: "transit", elementType: "all", stylers: [{ visibility: "off" }] },
    // Style roads with specific colors
    { featureType: "road", elementType: "geometry", stylers: [{ color: "#304a7d" }] }, // Darker blue for roads
    // Display and style country borders
    {
        featureType: "administrative.country",
        elementType: "geometry.stroke",
        stylers: [{ color: "#4b6878" }] // Grey-blue color for country borders
    },
    // Display and style state borders
    {
        featureType: "administrative.province",
        elementType: "geometry.stroke",
        stylers: [{ color: "#4b6878" }] // Same as country borders
    },
    // Update park colors to match the style
    {
        featureType: "poi.park",
        elementType: "geometry.fill",
        stylers: [{ color: "#023e58" }] // Dark blue for park fill
    },
    {
        featureType: "poi.park",
        elementType: "labels.text.fill",
        stylers: [{ color: "#3C7680" }] // Greyish blue for park label text fill
    },
    // Update water body colors to match the style
    {
        featureType: "water",
        elementType: "geometry",
        stylers: [{ color: "#0e1626" }] // Very dark blue for water bodies
    },
    {
        featureType: "water",
        elementType: "labels.text.fill",
        stylers: [{ color: "#4e6d70" }] // Muted blue for water label text fill
    },
];

export default mapStyles;
