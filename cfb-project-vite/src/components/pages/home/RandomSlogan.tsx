
const slogans = [
    'Where Passion Meets Pigskin',
    'The Gridiron Authority',
    'Saturdays Are Sacred',
    'Eat, Sleep, CFB',
    'Your All-Access Pass to College Football',
    'Fueling Your Football Frenzy',
    'The Epicenter of College Pigskin',
    'Where Tradition Never Graduates',
    'Tailgating for the Digital Age',
    'Your Hometown for College Football',
    'The Playbook for the Pigskin Obsessed',
    'Where Legends Hit the Field',
    'Arming You with Gridiron Intelligence',
    'The Audible for College Football Fanatics',
    'Huddle Up for College Football Greatness',
    'Your Sideline Pass to the Action',
    'Bringing the Pageantry to Your Screen',
    'The Battlefield for College Football Supremacy',
    'Flying Your Colors in the Digital Realm',
    'The Scoreboard for the Truly Dedicated',
    'The Gridiron\'s Digital Sanctuary',
    'Football Glory 24/7/365',
    'Playbooks for the Pigskin Superfan',
    'The Endzone for College Football Enlightenment',
    'Tackling Your College Football Obsession',
    'The Playoff for Palmers and Pundits',
    'The Goalline Stand for Gridiron Greatness',
    'Your Tunnel to Pigskin Paradise',
    'Blitz the Competition with CFB Knowledge',
    'The Conversion Van for CFB Diehards'
];

const RandomSlogan = () => {
  const selectedPhrase = slogans[Math.floor(Math.random() * slogans.length)];
  return <div className="phrase">{selectedPhrase}</div>;
};

export default RandomSlogan;
