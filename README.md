# immigrants_task
Implement a class structure to represent the movement of immigrants across cities and countries.

An immigrant has the following characteristics:
• Passport;
• Initial amount of money in euros;
• City and country where you are currently located.
• List of relatives who are also immigrants;
• List of weapons at your disposal.

An immigrant's passport contains the following data:
• Name;
• Years.
• Country and city of birth.

The data for 1 weapon is as follows:
• Type (gun, bomb, machine gun).
• Black market price in euros.

Immigrants are:
• Normal immigrants - they must have a passport, do not own a weapon and have up to 10 relatives.
• Radical Immigrants - do not always carry a passport, have unlimited relatives (they may not), and have a maximum of 5 guns on them, but no bombs.
• Extremist Immigrants - do not hold a passport, have an unlimited number of relatives (may or may not), and may have an unlimited number of weapons on their person of any type.

We also have police officers in the app. Each of them has the following data:
• Name
• City and country where he works.

Police officers are:
• Police officers - they catch about 50% of illegal immigrants (radicals and extremists). However, they cannot arrest immigrants who carry a bomb. They check all immigrants, regardless of their type, whether they have a passport.
• Special forces - catch about 90% of illegal immigrants, whatever they are. They only screen immigrants who are radical and extremist.

Cities have the following characteristics:
• Name
• List of police officers.
• Number of inhabitants (which includes everyone who inhabits a certain city).
• List of immigrants.

States have the following characteristics:
• Name.
• List of cities in this country.

Each city has a certain number of residents and immigrants, and there are no cities without residents. Immigrants can enter a given country and a certain city of it, and for each immigrant who wants to enter, a police officer is randomly assigned to check him. If the immigrant is normal, it is skipped and added to the list of immigrants in the corresponding city. If he is not (ie he is a radical or an extremist) and if he does not have a passport, the relevant police officer with the probability determined for him apprehends him and a report is issued. In this case, the immigrant does not enter the city. Each immigrant can perform the following actions:
• To immigrate to another city on a random basis from the list of all cities in the country - then all his relatives immigrate as well, respectively their relatives and so on.
• To buy a certain weapon, as if there is not enough money an extraordinary situation occurs and the immigrant dies of anger, and is removed from the list of immigrants in the country.
• If he is radical – to start firing with all his weapons. Firing is an operation specific to each weapon that outputs an appropriate message and returns the number of rounds fired. Randomly generate casualties between up to 10 and 70% of rounds fired. So many people to leave as residents of the city.
• If he is an extremist - to explode a bomb - then an exceptional situation occurs in the program, an appropriate message is issued and the entire city is removed from the list of cities of a given country.

To implement a demo that:
1. Creates a country with 5 cities in it. Let the number of inhabitants be randomly set, randomly generated and police officers to be distributed equally in the cities.
2. Creates 100 immigrants, randomly assigned to be Normal, Extremist, or Radical. The probability of creating a radical should be 25%, an extremist – 35%, and a normal immigrant – 40%. Assign them random currencies and any amount of money in Euros, as well as a passport where possible. Radical immigrants should have a 35% chance of having a passport. Let everyone have 2 relatives from the rest of the immigrants enrolled on a random basis.
3. To create 200 weapons randomly. Have each immigrant try to buy a random 5 of them, such that if 1 weapon is sold, it is not sold again.
4. Let all immigrants randomly immigrate to a city. When an immigrant migrates on a random basis, a police officer is assigned to check his passport.
5. To display for each immigrant the city in which he currently resides, whether he has a passport, the money he has and the names of his relatives.
6. To randomly select 20 immigrants to shoot or blow themselves up if they have a bomb.
7. To display the cities sorted by the number of surviving inhabitants in them, the immigrants - by the amount of money, as well as all immigrants who had a bomb but already detonated it
