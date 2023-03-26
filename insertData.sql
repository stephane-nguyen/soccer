INSERT INTO club (name, country, city, league, stadium, number_of_trophy, coach) 
VALUES ('Bayern Munich', 'Germany', 'Munich', 'Bundesliga', 'Allianz Arena', 31, 'Julian Nagelsmann'),
('Manchester United', 'England', 'Manchester', 'Premier League', 'Old Trafford', 66, 'Ole Gunnar Solskjær'),
('Barcelona', 'Spain', 'Barcelona', 'La Liga', 'Camp Nou', 95, 'Xavi'),
('Real Madrid', 'Spain', 'Madrid', 'La Liga', 'Santiago Bernabeu', 34, 'Carlo Ancelotti');


INSERT INTO footballer (firstname, lastname, role, pace, shooting, passing, dribbling, defence, physical, age, salary, height, nationality, fk_club)
VALUES ('Robert', 'Lewandowski', 'ST', 90, 95, 75, 85, 40, 80, 33, 200000, 1.84, 'Poland', 1),
('Lionel', 'Messi', 'RW', 95, 95, 95, 96, 30, 65, 34, 350000, 1.70, 'Argentina', 3),
('Cristiano', 'Ronaldo', 'ST', 94, 93, 80, 89, 35, 85, 37, 400000, 1.87, 'Portugal', 4),
('Kylian', 'Mbappé', 'ST', 96, 90, 84, 92, 38, 81, 23, 250000, 1.78, 'France', 4),
('Erling', 'Haaland', 'ST', 92, 93, 68, 87, 39, 89, 21, 150000, 1.94, 'Norway', 1),
('Kevin', 'De Bruyne', 'CAM', 75, 88, 94, 88, 65, 76, 30, 300000, 1.81, 'Belgium', 2),
('Neymar', 'Jr', 'LW', 92, 87, 86, 95, 33, 67, 29, 280000, 1.75, 'Brazil', 3),
('Mohamed', 'Salah', 'RW', 94, 89, 75, 86, 45, 72, 29, 220000, 1.75, 'Egypt', 2),
('Luis', 'Suarez', 'ST', 70, 87, 65, 84, 55, 77, 34, 100000, 1.82, 'Uruguay', 3),
('Sadio', 'Mane', 'LW', 94, 85, 70, 89, 46, 80, 29, 180000, 1.75, 'Senegal', 2);
