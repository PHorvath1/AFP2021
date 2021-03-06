## Rendszerterv

## 1. A rendszer célja
---
A Renszer célja, hogy a felhasználó/ügyfél kényelmesen és egyszerűen tudjon járművet bérelni. 
Az alkalmazás megvalósítása során törekedni kell arra, hogy a felhasználói felület minél letisztultabb legyen,
a félre értések elkerülése és áttekithetőség érdekében. Az ügyfél jármű lista széles választéka közül válogathat.
Azért, hogy a keresés egyszerű és gördülékeny legyen, a járműveket a renszer csoportokba rendezi majd listázza ki.
A felhasználónak lehetősége van a már általa kibérelt járművek megtekitésére a Saját bérlések menüpont alatt.
Továbbá ezen menüpont alatt tájkozódhat a bérlés időtartamáról és a szolgáltatás díjairól.
A renszer kifejezetten csak Androidos eszközökön érhető el. A fejleszés során nem célunk más Operációs renszerrel
renelkező eszközre is fejleszteni.

## 2. Projektterv
---
#### Projektszerepkörök:
<br> Scrum master: Gulyás Péter
<br> Product Owner: Tóth István

#### Projektmunkások és felelősségeik:
<br>Frontend munkálatok:
<br>    - Csattos Bence
<br>    - Horváth Krisztián
<br>    - Horváth Péter
<br>A projekt frontend részén dolgozók feladata, hogy az alkalmazáshoz egy felhasználói felületet készítsenek.

<br>Backend munkálatok:
<br>    - Csattos Bence
<br>    - Horváth Krisztián
<br>    - Horváth Péter
<br>A projekt backend területét végzők feladata, hogy szolgáltatást készítsenek, amelyre majd épül az alkalmazás.

| Funkció / Story | Feladat / Taszk | Prioritás | Becslés | Akt. Becslés | Eltelt | Hátralévő |
| --- | --- | --- | --- | --- | --- | --- |
| Követelmény Specifikáció |  | 0 | 7 | 7 | 7 | 0 |
| Funkcionális Specifikáció |  | 0 | 8 | 8 | 8 | 0 |
| Rendszerterv |  | 0 | 8 | 8 | 3 | 5 |
| Fejlesztés |  | 0 | 39 | 39 | 0 | 39 |
|  | Adatbázis létrehozása | 0 | 2 | 2 | 0 | 2 |
|  | Regiszráció | 0 | 4 | 4 | 0 | 4 |
|  | Bejelentkezés | 0 | 3 | 3 | 0 | 3 |
|  | Saját adatok megtekintése | 0 | 3 | 3 | 0 | 3 |
|  | Jelszó módosítása | 1 | 3 | 3 | 0 | 3 |
|  | Járművek kilistázása | 0 | 8 | 8 | 0 | 8 |
|  | Jármű megtekintése | 1 | 4 | 4 | 0 | 4 |
|  | Kikölcsönzés | 0 | 5 | 5 | 0 | 5 |
|  | Kikölcsönzött járművek megtekintése | 1 | 4 | 4 | 0 | 4 |
|  | Értékelés | 2 | 3 | 3 | 0 | 3 |
| Tesztelés | Teszt jegyzőkönyv | 0 | 5 | 5 | 0 | 5 |
| Projektvezetés |  | 0 | 12 | 12 | 0 | 12 |

## 3. Üzleti folyamatok modellje
---
![Image](https://github.com/PHorvath1/AFP2021/blob/main/Pictures/igenyelt_uzleti_folyamat.png)

## 4. Követelmények
---
* **Funkcionális követelmények**:
    - Felhasználó adatainak tárolása
    - Jármű adatainak tárolása
    - Android környezeten való működés
    - Járművek listázása
    - Elérhető járművek szűrése
    - Járművek adatainak megtekintése
    - Jármű kibérlése
* **Nem funkcionális követelmény**:
    - Az alkalmazásnak gyorsnak kell lennie
    - Az alkalmazás felületének egyszerűnek kell lennie
    - Navigációs menü kialakítása

## 5. Funkcionális terv
---
### Ügyfél, a rendszer felhasználója:
- Felregisztrálhat a renszerre, miután kitöltötte a kötelező Form-okat.
- E-mail cím és jelszó kombinácíóval, egy validácíó után beléphet a rendszerbe.
- Az ügyfélnek lehetősége van a Jelszó változtatásra, a Saját adatok(My Profile)
menüpont alatt.
- Lehetősége van jármüvet bérelni, sikeres bejelentkezés után a Jármű lista menüpontban(Car List),
 miután megadt a bérlés kezdetét, végét és az átvétel helyszínét.
- A Saját bérlések(My Rentals) menüpont alatt, lehetősége van megtekinteni a már kibérelt járműveket.
- (Opcionális) A Kontakt menüpont alatt felveheti a kapcsolatot a Jármű bérlő üzemeltetőivel,
 ahhol feltetheti kérdéseit és probléma esetén segítséget kérhet.

### (Opcionális) Admin:
- Lehetősége van új járműveket hozzáadni a renszerhez.
- Módosítani tudja a járművek számát
- Probléma esetén, szabaddá teheti a már lefoglalt járművet. 

### Menü-hierarchiák:

* Bejelentkezés
    - Bejelentkezés
    - Regisztráció
* Menü
    - Főmenü
    - Saját bérlések
    - Saját Profil
    - Járművek lista

## 6. Fizikai környezet
---
### Fejlesztői környezet:

- Java, Gradle, Android Studio
- Visual Studio Code, InteliJ IDEA vagy Net Beans
- (Opcionális) Android OP. Rendszeres telefon a könnyebb fejlesztés érdekében.
- Postman 
- git (Github account) 

### Futtatási környezet:
Annak érdekében, hogy az ügyfél igénybe tudja venni a renszer  szolgáltatásait, rendelkezni kell
egy okostelefonnal. Az okostelefonnak meg kell felelnie egyes specifikációknak. 

#### Specifikáció:
- Android 4.1(Jelly Bean) vagy annál frissebb operációs rendszer.
- Internet kapcsolat
- Google Play Áruház 
- Minimális renszer követelménynek meg kell felelnie.


### Minimális Rendszerigény
| | |
| --- | --- | 
| Operációs rendszer |  Android 4.1.4 ,Android 4.2, Android 4.4.2, or Android 4.4.4 |
|Processzor|Snapdragon 768G vagy Jobb Intel Atom® Processor Z2520 1.2 GHz vagy gyorsabb|
|Tárhely|Minimum 120MB tárhely |
|RAM|Minimum 512Mb, Ajánlott 2GB|
|Internet|Az Applikáió futtatásához internet kapcsolat szükséges|



## 7. Architekturális terv
---
A kliens és a szerver HTTP/HTTPS protokolon keresztül kommunikál egymással.

### Adatbázis:
- A rendzer adatainak tárolásához szükséges egy Adatbázis, a rendszerhez MySql-t alkalmazunk.
### Backend:
-   (Opcionális) Docker: Konténerizáció biztosítja, ezáltal a  Backend és az Adatbázis
    könnyen kezelhető és könnyen futtatható minden számítógépes operációs renszeren. 
    Ezzel elkerülhető a hosszadalmas konfigurálás és Renszer kitelepítését is egyszerübbé teszi.

- (Opcionális) Composer: Függőségek vezérlése és építése.(Dependency management)

- (Opcionális) Swagger: API-k struktúrájának, illetve a backend által szolgáltatott Endpoint-ok útvonalainak leírására szolgál.

### Android:
- Grandle: Függőségek kezelése és építése.(Dependency management)
- Retrofit: REST kliens Java és Android Alkalmazásokhoz, amely lehetővé teszi az egyszerű kommunikációt a kliens és szerver között.
- Lombok: Getter, Setter , Konstruktor egyszerűsítésére szolgál.
- JUni5 & Jupiter: Tesztelési keretrendszer a Unit tesztek megírásához.
- (Opcionális) SLF4: Kivételek, hibák naplozására alkalmazható dependecy.


![Image](https://github.com/PHorvath1/AFP2021/blob/main/Pictures/BackendPlan.png)

## 8. Adatbázis terv
---
![Image](https://github.com/PHorvath1/AFP2021/blob/main/Pictures/Database_plan.png)

## 9. Implementációs terv
---
Az alkalmazás Android operációs rendszerre készül Android Studioban, Java nyelvben. Ezen kívül a következő
technológiákat fogjuk használni:
- A kommunikáció HTTP/HTPPS protokoll segítségével zajlik a szerver és a kliens között.
- A backend fejlesztése PHP nyelv formájában fog megvalósulni, a lekérdezésekhez MySql-t használunk.
- A kliens a szolgáltatást egy REST API segítségével éri el.
- A Unit tesztek megírására JUni5-t és Jupiter-t használunk.

## 10. Teszt terv
---
**Tesztelési eljárások**
* **Unit teszt:**
    A metódusok működésének ellenőrzése céljából unit teszteket kell írni. A metódusoknak át kell mennie a teszteken,
    hogy késznek tekinthetők legyenek.
* **Alfa teszt:**
    Az alfa tesztet a fejlesztők végzik. A alfa teszt célja, hogy teszteljük a már meglévő funkciókat, hogy azok az
    elvártnak megfelelően működnek-e. A teszt akkor tekinthető sikeresnek, ha különböző Android rendszereken minden funkció megfelelően működik.

**Tesztelendő funkciók**
* **Backend Service:**
    Képesnek kell lennie több klienst egyidőben kiszolgálni.
    Képesnek kell lennie, az adatbázisban műveleteket végezni (hozzáadni, törölni, módosítani).
* **Android:**
    A bejelentkezési és regisztrációs felületnek elérhetőnek kell lennie, minden felhasználó számára. Az alkalmazás
    elindításakor a bejelentkezési felület jelenik meg. Ezen a felületen kell belépni az adatok megadásával. 
    Nem létező fiók esetén, hibát kell kapni. Sikeres bejelentkezés esetén, a felhasználónak el kell érnie a funkciókat.

## 11. Telepítési terv
---
Az alkalmazás telepítése a következőképpen fog zajlani:

Az alkalmazás telepítése előtt meg kell győzödni a telepítési előfeltételek teljesüléséről. Ezen
előfeltételek megtekinthetők a rendszerterv "Fizikai környezet" 
* Futtatási környezet
* Specifikáció
* Minimális rendszerigény
alpontjaiban.

Amennyiben az előfeltételek teljesülnek, akkor a következő lépésekkel telepíthető az alkalmazás:
1. Rákeres az alkalmazás nevére a Google Play áruházban
2. Rábök a megfelelő alkalmazás ikonjára
3. Ellenőrzi, hogy a megfelelő alkalmazást nyomta meg
4. Elindítja a letöltést
5. A letöltés befejeztével a telepítés automatikusan megtörténik

## 12. Karbantartási terv
---
Az alkalmazás karbantartására időről időre sor fog kerülni, amely tartalmazza a programhibák javítását,
az alkalmazás hosszútávú müködése érdekében végzett módosításokat, frissítéseket, esetlegesen új funkciók hozzáadását
és az alkalmazás teljesítménybeli fejlesztését, a környezeti feltételek változása miatt megfogalmazott program- illetve
állomány módosítási feltételeket. Új Android verzió kiadása esetén ellenőrizni kell, hogy az alkalmazás kompatibilis-e
az új verzióval. Amennyiben az alkalmazás használhatatlanságát okozó hibát találunk, a lehető leghamarabb elkezdjük 
annak javítását.
