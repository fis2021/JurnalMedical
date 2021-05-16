# Aplicatie Jurnal Medical
##Membrii Echipei: 
Cozma Rebeca-Cristina, Cojocaru Ionut-Florin
## Descriere Generala
Aplicatia isi propune sa ajute medicii si pacientii lor, oferind posibilitatea de a imbunatatii transmiterea informatilor de la pacient la medic si de a monitoriza in permanenta starea de sanatate a pacientilor.
Pentru dezvoltarea aplicatiei am folosit:
* [Java  16](https://www.oracle.com/java/technologies/javase-downloads.html)
* [JavaFX](https://openjfx.io/openjfx-docs/) (as GUI)
* [Maven](https://maven.apache.org/) / [Gradle](https://gradle.org/) (as build tools)
* [Nitrite Java](https://www.dizitart.org/nitrite-database.html) (as Database)

## Înregistrare (atât pentru pacient, cât și pentru medic):
* Utilizatorul trebuie să se înregistreze mai întâi în aplicație selectând unul dintre cele 2 roluri: pacient sau medic. Ambele roluri necesită un nume de utilizator unic și o parolă.
## Pacient:
* Dupa conectare, un pacient va putea vizualiza o listă cu istoricul simptomelor adaugate in jurnal.In cazul in care pacientul nu a adugat nici un simptom, va aparea mesajul „Jurnal gol!”.
* Acesta poate sa adauge orice simptom doreste.Un simptom nu poate fi adaugat de doua ori.
* De asemenea, pacientii pot sterge anumite simptome.Un simptom poate fi sters numai daca se afla in jurnalul pacientului.
* Pe langa aceste functionalitati, un pacient poate sa primeasca si sa vizualizeze feedback-ul trimis de catre un medic.
##Medic:
* După ce medicul se conectează, acesta poate vizualiza o lista a pacientilor sai. Daca acesta nu a adugat nici un pacient in lista, se va afisa mesajul „Nici un pacient!”.
* Acesta poate adauga pacienti care au deja un cont creat.Un pacient nu poate fi adugat de doua ori.
* Medicul poate sterge un pacient.Pacientul trebuie sa indeplineasca simultan conditiile:
 * 1. Sa aiba cont creat
 * 2. Sa se afle in lista de pacienti a medicului
* De asemenea, are posibilitatea de a vizualiza simptomele fiecarui pacient in parte.(conditiile de mai sus sunt valabile si aici)
* Daca doreste, dupa vizualizarea jurnalului unui pacient, medicul poate trimite feedback catre acel pacient.
