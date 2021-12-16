package com.dicoding.katonmoviecatalogue.utils

import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.source.remote.response.*

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                460462,
                "A Star Is Born",
                "Romance/Musical",
                7.6,
                "October 19, 2018",
                214,
                "After falling in love with struggling artist Ally, Jackson, a musician, coaxes her to follow her dreams, while he battles with alcoholism and his personal demons.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                2,
                "Alita : Battle Angel",
                "Action/Sci-fi",
                7.3,
                "February 5, 2019",
                212,
                "Alita, a battle cyborg, is revived by Ido, a doctor, who realises that she actually has the soul of a teenager. Alita then sets out to learn about her past and find her true identity.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                3,
                "Aquaman",
                "Action/Adventure",
                6.9,
                "December 21, 2018",
                222,
                "Half-human, half-Atlantean Arthur is born with the ability to communicate with marine creatures. He goes on a quest to retrieve the legendary Trident of Atlan and protect the water world.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                4,
                "Bohemian Rhapsody",
                "Musical/Drama",
                7.9,
                "October 27, 2018",
                213,
                "With his impeccable vocal abilities, Freddie Mercury and his rock band, Queen, achieve superstardom. However, amidst his skyrocketing success, he grapples with his ego, sexuality and a fatal illness.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                5,
                "Cold Pursuit",
                " Action/Thriller",
                6.2,
                "February 15, 2019",
                138,
                "Nels Coxman, a snowplow driver, celebrates his 'Citizen of the Year' award. However, his life turns upside down when his son dies due to a forced heroin overdose.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                6,
                "Creed II",
                "Drama/Sport",
                7.1,
                "November 28, 2018",
                210,
                "In 1985, Ivan Drago killed Apollo Creed in a tragic boxing match. Under the guidance of his trainer Rocky, Apollo's son Adonis confronts Drago's son in an ultimate showdown.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        /*
        movies.add(
            MovieEntity(
                7,
                "The Crimes of Grindlewald",
                "Fantasy/Adventure",
                6.5,
                "November 14, 2018",
                213,
                "Gellert Grindelwald plans to raise an army of wizards to rule over non-magical beings. In response, Newt Scamander's former professor, Albus Dumbledore, seeks his help to stop him.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                8,
                "Glass",
                "Thriller/Drama",
                6.6,
                "January 16, 2019",
                291,
                "While David confronts Kevin, a group of armed men intervene. Now locked in a mental facility with Elijah, the two find their superhuman abilities being questioned by Ellie, a secretive psychiatrist.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                9,
                "How To Train Your Dragon 3",
                "Family/Fantasy",
                7.5,
                "January 9, 2019",
                144,
                "Hiccup aims to unite the vikings and the dragons in order to bring peace on the island of Berk. However, he must stop the evil Grimmel and his devious plans to wipe out all dragons.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                10,
                "Avengers: Infinity War",
                "Action/Sci-fi",
                8.4,
                "April 25, 2018",
                229,
                "The Avengers must stop Thanos, an intergalactic warlord, from getting his hands on all the infinity stones. However, Thanos is prepared to go to any lengths to carry out his insane plan.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                11,
                "Mary Queen of Scots",
                "Drama/History",
                6.3,
                "January 18, 2019",
                124,
                "Mary Stuart returns to Scotland in order to claim her rightful throne. She attempts to overthrow her cousin Elizabeth I, Queen of England, but finds herself condemned to years of imprisonment.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                12,
                "Master Z: IP Man Legacy",
                "Action/Martial Arts",
                6.5,
                "December 29, 2018",
                123,
                "A martial artist decides to lay low following his humiliating loss to the famous Ip Man. However, various circumstances put him in the cross hairs of a powerful drug smuggler of foreign descent.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                13,
                "Mortal Engines",
                "Action/Sci-fi",
                6.1,
                "December 13, 2018",
                218,
                "In a post-apocalyptic world where cities move and consume each other to survive, two strangers come together to stop a sinister and destructive conspiracy.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                14,
                "Overlord",
                "Horror/War",
                6.6,
                "October 7, 2018",
                148,
                "Towards the end of World War II, American paratroopers set out to destroy a German radio tower. Soon enough, things take a murky turn when they come across a vicious secret.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                15,
                "Ralph Breaks the Internet",
                "Comedy/Animation",
                7.6,
                "October 19, 2018",
                214,
                "Ralph and his best friend, Vanellope, face various challenges as they visit the uncharted land of the Internet through a Wi-Fi router at the arcade to save the game, Sugar Rush.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                16,
                "Robin Hood",
                "Adventure/Action ",
                5.3,
                "November 20, 2018",
                214,
                "Lord Robin of Loxley seeks vengeance after he returns from the Third Crusade to find that the corrupt Sheriff of Nottingham has declared him dead and claimed all his property.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                17,
                "Serenity",
                "Drama/Mystery",
                5.4,
                "January 19, 2018",
                214,
                "Baker Dill enjoys his tranquil life in Plymouth Island. However, his life turns upside down when his ex-wife, Karen, tracks him down and offers him \$10 million to get rid of her abusive new husband.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                18,
                "Spiderman: Into The Spiderverse",
                "Family/Action",
                8.4,
                "December 12, 2018",
                156,
                "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        movies.add(
            MovieEntity(
                19,
                "T-34",
                "War/Action",
                6.7,
                "January 19, 2018",
                214,
                "A group of brave soldiers, who are held captive in a German concentration camp, devises a plan to evade in their heavily damaged T-34 tank during World War II.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )

         */

        return movies
    }

    fun generateDummyTvshows(): List<TvshowEntity> {

        val tvshows = ArrayList<TvshowEntity>()

        tvshows.add(
            TvshowEntity(
                88396,
                "Arrow",
                "Action",
                7.9,
                "November 17, 2017",
                3,
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
        )
        )
        tvshows.add(
            TvshowEntity(
                2,
                "Doom Patrol",
                "Comedy-drama",
                7.9,
                "February 15, 2019",
                3,
                "Doom Patrol is a team of traumatized and downtrodden superheroes, each of whom has suffered a horrible accident that gave them superhuman abilities but also left them scarred and disfigured. The members of the team have found their purpose through The Chief and have come together to investigate some of the world's weirdest phenomena. After The Chief mysteriously disappears, though, the reluctant heroes find themselves called to action by Cyborg, who comes to them with a mission that they cannot refuse. Doom Patrol -- part support group, part superhero team -- is a band of superpowered freaks fighting for a world that wants nothing to do with them.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                3,
                "Dragon Ball",
                "Action/Adventure",
                9.0,
                "February 26, 1986",
                9,
                "Goku and Bulma's search continues for the seven Dragonballs, while he met new friends and fearsome enemies in his journey",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                4,
                "Fairytail",
                "Adventure",
                7.5,
                "October 12, 2009",
                9,
                "Lucy, a celestial wizard, meets and befriends Natsu, a dragon slayer wizard. They, along with others from the Fairy Tail guild, embark on various paid missions to fight crime and wrongdoings.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                5,
                "Family Guy",
                "Sitcom/Comedy",
                8.1,
                "January 31, 1999",
                19,
                "Peter Griffin and his family of two teenagers, a smart dog, a devilish baby and his wife find themselves in some of the most hilarious scenarios.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                6,
                "The Flash",
                "Drama",
                7.6,
                "October 7, 2014",
                7,
                "After mastering the skill of archery on a deserted island, multi-millionaire playboy Oliver Queen returns to his city to take on the vigilante persona of Arrow to fight crime and corruption.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        /*
        tvshows.add(
            TvshowEntity(
                7,
                "Game Of Throne",
                "Drama",
                7.9,
                "April 17, 2011",
                8,
                "Nine noble families wage war against each other in order to gain control over the mythical land of Westeros. Meanwhile, a force is rising after millenniums and threatens the existence of living men.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                8,
                "Gotham",
                "Action",
                7.8,
                "September 22, 2014",
                5,
                "Detective James Gordon is a new recruit assigned to investigate the murder of Thomas and Martha Wayne. The case acquaints him with the slain couple's son and future crusader, Bruce.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                9,
                "Grey Anatomy",
                "Drama ",
                7.5,
                "March 27, 2005",
                18,
                "Surgical interns and their supervisors embark on a medical journey where they become part of heart-wrenching stories and make life-changing decisions in order to become the finest doctors.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                10,
                "Hanna",
                "Drama",
                6.9,
                "January 17, 2014",
                6,
                "Hanna is an extraordinary girl who has been raised in the forest, evading the relentless pursuit of an off-the-book CIA agent. This series -- part high-concept thriller, part coming-of-age drama -- follows the girl on her journey as she tries to unearth the truth behind who she is. \"Hanna\" is based on the 2011 film of the same name that starred Oscar-nominated actress Saoirse Ronan in the title role.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                11,
                "Iron Fist",
                "Action/Superhero",
                6.9,
                "March 17, 2017",
                2,
                "Danny Rand decides it is time to return to New York after 15 years. Things take a turn when he tries to claim his family's company from Harold Meachum.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                12,
                "Naruto Shipudden",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                13,
                "NCIS",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                14,
                "Riverdale",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                15,
                "Shameless",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                16,
                "Suppergirl",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                17,
                "Supernatural",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                18,
                "the Simpson",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                19,
                "The Umbrella Academy",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )
        tvshows.add(
            TvshowEntity(
                20,
                "The Walking Dead",
                "Action",
                7.9,
                "November 17, 2007",
                21,
                "Naruto, an adolescent ninja, dreams of becoming the Hokage in his village.",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )

         */

        return tvshows
    }

    fun generateMovieRepository() : List<Movies>{
        val movies = ArrayList<Movies>()

        movies.add(
            Movies(460462,
            "Spiderman: Into The Spiderverse",
            "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
            "December 12, 2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            156,
            8.6,
        ))

        movies.add(
            Movies(460462,
                "Spiderman: Into The Spiderverse",
                "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
                "December 12, 2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                156,
                8.6,
            ))

        movies.add(
            Movies(460462,
                "Spiderman: Into The Spiderverse",
                "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
                "December 12, 2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                156,
                8.6,
            ))

        movies.add(
            Movies(460462,
                "Spiderman: Into The Spiderverse",
                "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
                "December 12, 2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                156,
                8.6,
            ))

        movies.add(
            Movies(460462,
                "Spiderman: Into The Spiderverse",
                "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
                "December 12, 2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                156,
                8.6,
            ))

        movies.add(
            Movies(460462,
                "Spiderman: Into The Spiderverse",
                "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
                "December 12, 2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                156,
                8.6,
            ))

        return movies
    }

    fun generateTvShowResponse() : List<TvShow>{
        val tvShows = ArrayList<TvShow>()

        tvShows.add(
            TvShow(88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-03-19",
                "https://image.tmdb.org/t/p/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
            ))

        tvShows.add(
            TvShow(88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-03-19",
                "https://image.tmdb.org/t/p/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
            ))

        tvShows.add(
            TvShow(88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-03-19",
                "https://image.tmdb.org/t/p/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
            ))

        tvShows.add(
            TvShow(88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-03-19",
                "https://image.tmdb.org/t/p/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
            ))

        tvShows.add(
            TvShow(88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-03-19",
                "https://image.tmdb.org/t/p/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
            ))

        tvShows.add(
            TvShow(88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "2021-03-19",
                "https://image.tmdb.org/t/p/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
            ))

        return tvShows
    }

    fun generateDetailMovie() : List<DetailMovies>{
        val movie = ArrayList<DetailMovies>()
        val genres = ArrayList<Genre>()
        genres.add(Genre(
            1,
            "Action"
        ))

        movie.add(DetailMovies(
            460462,
            "Spiderman: Into The Spiderverse",
            "After gaining superpowers from a spider bite, Miles Morales protects the city as Spider-Man. Soon, he meets alternate versions of himself and gets embroiled in an epic battle to save the multiverse.",
            "December 12, 2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            8.6,
            156,
            genres,
        ))
        return movie
    }

    fun generateDetailTv() : List<DetailTvShow>{
        val tv = ArrayList<DetailTvShow>()
        val genres = ArrayList<Genre>()
        genres.add(Genre(
            1,
            "Action"
        ))

        tv.add(DetailTvShow(
            88396,
            "The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "2021-03-19",
            "https://image.tmdb.org/t/p/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            7.9,
            3,
            genres)
        )

        return tv
    }
}