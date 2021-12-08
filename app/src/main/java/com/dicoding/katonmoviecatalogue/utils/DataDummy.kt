package com.dicoding.katonmoviecatalogue.utils

import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity

object DataDummy {
    /*
    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "m1",
                "A Star Is Born",
                "Romance/Musical",
                "7.6",
                "October 19, 2018",
                "2h 14m",
                "Bradley Cooper",
                "After falling in love with struggling artist Ally, Jackson, a musician, coaxes her to follow her dreams, while he battles with alcoholism and his personal demons.",
                false,
                R.drawable.poster_a_start_is_born
            )
        )
        movies.add(
            MovieEntity(
                "m2",
                "Alita : Battle Angel",
                "Action/Sci-fi",
                "7.3",
                "February 5, 2019",
                "2h 2m",
                "Robert Rodriguez",
                "Alita, a battle cyborg, is revived by Ido, a doctor, who realises that she actually has the soul of a teenager. Alita then sets out to learn about her past and find her true identity.",
                false,
                R.drawable.poster_alita
            )
        )
        movies.add(
            MovieEntity(
                "m3",
                "Aquaman",
                "Action/Adventure",
                "6.9",
                "December 21, 2018",
                "2h 22m",
                "James Wan",
                "Half-human, half-Atlantean Arthur is born with the ability to communicate with marine creatures. He goes on a quest to retrieve the legendary Trident of Atlan and protect the water world.",
                false,
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            MovieEntity(
                "m4",
                "Bohemian Rhapsody",
                "Musical/Drama",
                "7.9",
                "October 27, 2018",
                "2h 13m",
                "Bryan Singer, Dexter Fletcher",
                "With his impeccable vocal abilities, Freddie Mercury and his rock band, Queen, achieve superstardom. However, amidst his skyrocketing success, he grapples with his ego, sexuality and a fatal illness.",
                false,
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            MovieEntity(
                "m5",
                "Cold Pursuit",
                " Action/Thriller",
                "6.2",
                "February 15, 2019",
                "1h 38m",
                "Hans Petter Moland",
                "Nels Coxman, a snowplow driver, celebrates his 'Citizen of the Year' award. However, his life turns upside down when his son dies due to a forced heroin overdose.",
                false,
                R.drawable.poster_cold_persuit
            )
        )
        movies.add(
            MovieEntity(
                "m6",
                "Creed II",
                "Drama/Sport",
                "7.1",
                "November 28, 2018",
                "2h 10m",
                "Steven Caple Jr.",
                "In 1985, Ivan Drago killed Apollo Creed in a tragic boxing match. Under the guidance of his trainer Rocky, Apollo's son Adonis confronts Drago's son in an ultimate showdown.",
                false,
                R.drawable.poster_creed
            )
        )
        movies.add(
            MovieEntity(
                "m7",
                "The Crimes of Grindlewald",
                "Fantasy/Adventure",
                "6.5",
                "November 14, 2018",
                "2h 13m",
                "David Yates",
                "Gellert Grindelwald plans to raise an army of wizards to rule over non-magical beings. In response, Newt Scamander's former professor, Albus Dumbledore, seeks his help to stop him.",
                false,
                R.drawable.poster_crimes
            )
        )
        movies.add(
            MovieEntity(
                "m8",
                "Glass",
                "Thriller/Drama",
                "6.6",
                "January 16, 2019",
                "2h 9m",
                "M. Night Shyamalan",
                "While David confronts Kevin, a group of armed men intervene. Now locked in a mental facility with Elijah, the two find their superhuman abilities being questioned by Ellie, a secretive psychiatrist.",
                false,
                R.drawable.poster_glass
            )
        )
        movies.add(
            MovieEntity(
                "m9",
                "How To Train Your Dragon 3",
                "Family/Fantasy",
                "7.5",
                "January 9, 2019",
                "1h 44m",
                "Dean DeBlois",
                "Hiccup aims to unite the vikings and the dragons in order to bring peace on the island of Berk. However, he must stop the evil Grimmel and his devious plans to wipe out all dragons.",
                false,
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            MovieEntity(
                "m10",
                "Avengers: Infinity War",
                "Action/Sci-fi",
                "8.4",
                "April 25, 2018",
                "2h 29m",
                "Anthony Russo, Joe Russo",
                "The Avengers must stop Thanos, an intergalactic warlord, from getting his hands on all the infinity stones. However, Thanos is prepared to go to any lengths to carry out his insane plan.",
                false,
                R.drawable.poster_infinity_war
            )
        )
        movies.add(
            MovieEntity(
                "m11",
                "Mary Queen of Scots",
                "Drama/History",
                "6.3",
                "January 18, 2019",
                "2h 4m",
                "Josie Rourke",
                "Mary Stuart returns to Scotland in order to claim her rightful throne. She attempts to overthrow her cousin Elizabeth I, Queen of England, but finds herself condemned to years of imprisonment.",
                false,
                R.drawable.poster_marry_queen
            )
        )
        movies.add(
            MovieEntity(
                "m12",
                "Master Z: IP Man Legacy",
                "Action/Martial Arts",
                "6.5",
                "December 29, 2018",
                "1h 47m",
                "Yuen Woo-ping",
                "A martial artist decides to lay low following his humiliating loss to the famous Ip Man. However, various circumstances put him in the cross hairs of a powerful drug smuggler of foreign descent.",
                false,
                R.drawable.poster_master_z
            )
        )
        movies.add(
            MovieEntity(
                "m13",
                "Mortal Engines",
                "Action/Sci-fi",
                "6.1",
                "December 13, 2018",
                "2h 8m",
                "Christian Rivers",
                "In a post-apocalyptic world where cities move and consume each other to survive, two strangers come together to stop a sinister and destructive conspiracy.",
                false,
                R.drawable.poster_mortal_engines
            )
        )
        movies.add(
            MovieEntity(
                "m14",
                "Overlord",
                "Horror/War",
                "6.6",
                "October 7, 2018",
                "1h 48m",
                "Julius Avery",
                "Towards the end of World War II, American paratroopers set out to destroy a German radio tower. Soon enough, things take a murky turn when they come across a vicious secret.",
                false,
                R.drawable.poster_overlord
            )
        )
        movies.add(
            MovieEntity(
                "m15",
                "Ralph Breaks the Internet",
                "Comedy/Animation",
                "7.6",
                "October 19, 2018",
                "2h 14m",
                "Phil Johnston, Rich Moore",
                "Ralph and his best friend, Vanellope, face various challenges as they visit the uncharted land of the Internet through a Wi-Fi router at the arcade to save the game, Sugar Rush.",
                false,
                R.drawable.poster_ralph
            )
        )
        movies.add(
            MovieEntity(
                "m16",
                "Robin Hood",
                "Adventure/Action ",
                "5.3",
                "November 20, 2018",
                "2h 14m",
                "Bradley Cooper",
                "Lord Robin of Loxley seeks vengeance after he returns from the Third Crusade to find that the corrupt Sheriff of Nottingham has declared him dead and claimed all his property.",
                false,
                R.drawable.poster_robin_hood
            )
        )
        movies.add(
            MovieEntity(
                "m17",
                "Serenity",
                "Drama/Mystery",
                "5.4",
                "January 19, 2018",
                "2h 14m",
                "Steven Knight",
                "Baker Dill enjoys his tranquil life in Plymouth Island. However, his life turns upside down when his ex-wife, Karen, tracks him down and offers him \$10 million to get rid of her abusive new husband.",
                false,
                R.drawable.poster_serenity
            )
        )
        movies.add(
            MovieEntity(
                "m18",
                "Spiderman: Into The Spiderverse",
                "Family/Action",
                "8.4",
                "December 12, 2018",
                "1h 56m",
                " Peter Ramsey, Bob Persichetti, Rodney Rothman",
                "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
                false,
                R.drawable.poster_spiderman
            )
        )
        movies.add(
            MovieEntity(
                "m19",
                "T-34",
                "War/Action",
                "6.7",
                "January 19, 2018",
                "2h 14m",
                "Bradley Cooper",
                "A group of brave soldiers, who are held captive in a German concentration camp, devises a plan to evade in their heavily damaged T-34 tank during World War II.",
                false,
                R.drawable.poster_t34
            )
        )

        return movies
    }

    fun generateDummyTvshows(): List<TvshowEntity> {

        val tvshows = ArrayList<TvshowEntity>()

        tvshows.add(
            TvshowEntity(
                "t1",
                "Arrow",
                "Action",
                "7.9",
                "November 17, 2017",
                "3 Seasons",
                "David Nuttler",
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                R.drawable.poster_arrow
        )
        )
        tvshows.add(
            TvshowEntity(
                "t2",
                "Doom Patrol",
                "Comedy-drama",
                "7.9",
                "February 15, 2019",
                "3 Seasons",
                "Arnold Drake; Bob Haney; Bruno Premiani",
                "Doom Patrol is a team of traumatized and downtrodden superheroes, each of whom has suffered a horrible accident that gave them superhuman abilities but also left them scarred and disfigured. The members of the team have found their purpose through The Chief and have come together to investigate some of the world's weirdest phenomena. After The Chief mysteriously disappears, though, the reluctant heroes find themselves called to action by Cyborg, who comes to them with a mission that they cannot refuse. Doom Patrol -- part support group, part superhero team -- is a band of superpowered freaks fighting for a world that wants nothing to do with them.",
                false,
                R.drawable.poster_doom_patrol
            )
        )
        tvshows.add(
            TvshowEntity(
                "t3",
                "Dragon Ball",
                "Action/Adventure",
                "9.0",
                "February 26, 1986",
                "9 Seasons",
                "Toshiki Inoue",
                "Goku and Bulma's search continues for the seven Dragonballs, while he met new friends and fearsome enemies in his journey",
                false,
                R.drawable.poster_dragon_ball
            )
        )
        tvshows.add(
            TvshowEntity(
                "t4",
                "Fairytail",
                "Adventure",
                "7.5",
                "October 12, 2009",
                "9 Seasons",
                "Hiro Mashima",
                "Lucy, a celestial wizard, meets and befriends Natsu, a dragon slayer wizard. They, along with others from the Fairy Tail guild, embark on various paid missions to fight crime and wrongdoings.",
                false,
                R.drawable.poster_fairytail
            )
        )
        tvshows.add(
            TvshowEntity(
                "t5",
                "Family Guy",
                "Sitcom/Comedy",
                "8.1",
                "January 31, 1999",
                "19 Seasons",
                "Seth MacFarlane",
                "Peter Griffin and his family of two teenagers, a smart dog, a devilish baby and his wife find themselves in some of the most hilarious scenarios.",
                false,
                R.drawable.poster_family_guy
            )
        )
        tvshows.add(
            TvshowEntity(
                "t6",
                "The Flash",
                "Drama",
                "7.6",
                "October 7, 2014",
                "7 Seasons",
                "David Nutter; Gabrielle Stanton",
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                R.drawable.poster_flash
            )
        )
        tvshows.add(
            TvshowEntity(
                "t7",
                "Game Of Throne",
                "Drama",
                "7.9",
                "April 17, 2011",
                "8 Seasons",
                "David Benioff; D. B. Weiss",
                "Nine noble families wage war against each other in order to gain control over the mythical land of Westeros. Meanwhile, a force is rising after millenniums and threatens the existence of living men.",
                false,
                R.drawable.poster_god
            )
        )
        tvshows.add(
            TvshowEntity(
                "t8",
                "Gotham",
                "Action",
                "7.8",
                "September 22, 2014",
                "5 Seasons",
                "Danny Cannon; Bruno Heller",
                "Detective James Gordon is a new recruit assigned to investigate the murder of Thomas and Martha Wayne. The case acquaints him with the slain couple's son and future crusader, Bruce.",
                false,
                R.drawable.poster_gotham
            )
        )
        tvshows.add(
            TvshowEntity(
                "t9",
                "Grey Anatomy",
                "Drama ",
                "7.5",
                "March 27, 2005",
                "18 Seasons",
                "Shonda Rhimes",
                "Surgical interns and their supervisors embark on a medical journey where they become part of heart-wrenching stories and make life-changing decisions in order to become the finest doctors.",
                false,
                R.drawable.poster_grey_anatomy
            )
        )
        tvshows.add(
            TvshowEntity(
                "t10",
                "Hanna",
                "Drama",
                "6.9",
                "January 17, 2014",
                "6 Seasons",
                "Nuttler",
                "Hanna is an extraordinary girl who has been raised in the forest, evading the relentless pursuit of an off-the-book CIA agent. This series -- part high-concept thriller, part coming-of-age drama -- follows the girl on her journey as she tries to unearth the truth behind who she is. \"Hanna\" is based on the 2011 film of the same name that starred Oscar-nominated actress Saoirse Ronan in the title role.",
                false,
                R.drawable.poster_hanna
            )
        )
        tvshows.add(
            TvshowEntity(
                "t11",
                "Iron Fist",
                "Action/Superhero",
                "6.9",
                "March 17, 2017",
                "2 Seasons",
                "David",
                "Danny Rand decides it is time to return to New York after 15 years. Things take a turn when he tries to claim his family's company from Harold Meachum.",
                false,
                R.drawable.poster_iron_fist
            )
        )
        tvshows.add(
            TvshowEntity(
                "t12",
                "Naruto Shipudden",
                "Action",
                "7.9",
                "November 17, 2007",
                "21 Seasons",
                "Masashi Kishimoto",
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                R.drawable.poster_naruto_shipudden
            )
        )
        tvshows.add(
            TvshowEntity(
                "t13",
                "NCIS",
                "Action",
                "7.7",
                "November 17, 2017",
                "19 Seasons",
                "David Nuttler",
                "Special Agent Leroy Jethro Gibbs is a skilled investigator. He leads a team of agents of the Naval Criminal Investigative Service's Major Case Response Team as they solve intense criminal cases.",
                false,
                R.drawable.poster_ncis
            )
        )
        tvshows.add(
            TvshowEntity(
                "t14",
                "Riverdale",
                "Action",
                "7.9",
                "November 17, 2017",
                "3 Seasons",
                "David Nuttler",
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                R.drawable.poster_riverdale
            )
        )
        tvshows.add(
            TvshowEntity(
                "t15",
                "Shameless",
                "Action",
                "7.9",
                "November 17, 2017",
                "3 Seasons",
                "Nuttler",
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                R.drawable.poster_shameless
            )
        )
        tvshows.add(
            TvshowEntity(
                "t16",
                "Suppergirl",
                "Superhero",
                "5.9",
                "November 17, 2017",
                "4 Seasons",
                "Rhimes",
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                R.drawable.poster_supergirl
            )
        )
        tvshows.add(
            TvshowEntity(
                "t17",
                "Supernatural",
                "Horror/Thriller",
                "7.1",
                "November 17, 2017",
                "12 Seasons",
                "Shonda Rhimes",
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                R.drawable.poster_supernatural
            )
        )
        tvshows.add(
            TvshowEntity(
                "t18",
                "the Simpson",
                "Action",
                "8.6",
                "December 17, 1989",
                "33 Seasons",
                "Matt Groening",
                "Working-class father Homer Simpson and his dysfunctional family deal with comical situations and the ups-and-downs of life in the town of Springfield.",
                false,
                R.drawable.poster_the_simpson
            )
        )
        tvshows.add(
            TvshowEntity(
                "t19",
                "The Umbrella Academy",
                "Drama/Action",
                "7.9",
                "November 17, 2017",
                "2 Seasons",
                "james Rick",
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                R.drawable.poster_the_umbrella
            )
        )
        tvshows.add(
            TvshowEntity(
                "t20",
                "The Walking Dead",
                "Horror/Thriller",
                "8.2",
                "October 17, 2010",
                "10 Seasons",
                "Jolly Dale; Caleb Womble",
                "In the wake of a zombie apocalypse, various survivors struggle to stay alive. As they search for safety and evade the undead, they are forced to grapple with rival groups and difficult choices.",
                false,
                R.drawable.poster_the_walking_dead
            )
        )

        return tvshows
    }

     */
}