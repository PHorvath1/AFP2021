## Funkcionális Specifikáció

## 1. Áttekintés
--- 
A projekt célja, hogy egy autókölcsönző applikációt fejlesszünk Android rendszerre. Az alkalmazás használatához
először le kell tölteni azt, majd elindítani. Az alkalmazás felhasználói rendszerrel fog működni, ami azt 
jelenti, hogy szükséges lesz a regisztrálás és a bejelentkezés a használathoz. Ebben az alkalmazásban egy menü
segítségével navigálhatunk a felületek között. A kinálat kivitel szerint lesz csoportosítva (Szedán, Kombi, 
stb.), de használhatunk további szűrőket. Minden járműhöz tartozni fog egy leírás is. A jármű kiválasztása után
a felhasználónak csak meg kell adni a számlázási adatait, a bérlés időtartamát illetve, hogy hol szeretné 
átvenni a járművet.
A felhasználónak lehetősége lesz az adatai megtekintésére, továbbá arra, hogy megváltoztassa a jelszavát.

## 2. Jelenlegi helyzet
---
A megrendelő szeretné az autó kölcsönzés menetét gyorsabbá és kényelmesebbé tenni, hogy minél több ember kihasználja a cége által nyújtott lehetőséget. Ezt a mobilapplikáció segítségével képzeli el, mivel sok ember rendelkezik ilyen készülékkel. A rendszerben a járművek kategóriákra vannak bontva és az ügyfél könnyedén kereshet az elérhető járművek közül. A megrendelő szeretné még, hogy a járművek részletes leírással is rendelkezzenek, mivel így az ügyfél sok kérdésre választ kap. Fontos az is, hogy a rendszerben az ügyfél a számlázási adatok megadása után kiválaszthatja, hogy hány napra kívánja kibérelni a járművet és a számára megfelelő helyet, ahol át kívánja venni a járművet. A rendszer a sikeres bérlés után az adminisztrációs feladatokat automatikusan kezeli.

## 3. Követelménylista
---

| modul| id | név | verzió | kifejtés | 
| --- | ---: | --- | --- | --- |
|Jogosultság|K1|Bejelentkezési Felület|1.0|A Bejelentkezési felület segítségével léphet be a felhasználó a rendszerbe miután megadta a emailcím és jelszó kombinációt. Amennyiben a jelszó nem mgfelelő vagy a felhasználó nem regisztrált a rendszer hiba üzenetet küld vissza.|
|Jogosultság|K2|Regisztrációs felület|1.0|A Regisztrációs felület segítségével csatlakozhat a renszerhez a felhasználó. A regisztrációhoz szükséges megadni e-mail címet, nevet,lakcímet és telefonszámot. A jelszavak kódolva kerülnek tárolásra az adatbázisban.|
|Modifikáció|K3|Jelszó módosítás|1.0|A Felhasználónak lehetősége van módosítani jelszavát, amennyiben rendelkezik a régi jelszavával. |
|Felület|K4|Android - Bejelentkezés|1.0|Az applikáció futtatásakor ez a felület fogadja a felhasználókat. A renszer igénybevételéhez a bejelentkezés elengedhetetlen.|
|Felület|K5|Android - Jelszó módosítás|1.0|A Kliens oldalon a menüből elérhető a "Saját adatok" nézet. Ezen nézeten lesz lehetőség a jelszó módosítására.| 
|Felület|K6| Android - Menu bar|1.0|A Kliens oldalon szükséges egy menüsor, amely lehetővé teszi a navigálást az Applikáción belül(View közötti váltást teszi lehetővé).|
|Felület|K7|Andoid View - Járművek Kilistázása|1.0|A nézeten belül elérhető egy almenü(az almenü elemei: Kupé,Kombi,SUV...), ennek segítségével lehet kiválasztani a jármű típusát, majd a kategórába tartozó járművek kilistázásra kerülnek(Clickable Recycler View segítségével).|
|Felület|K8|Android View - Saját Adatok|1.0|Ez a nézet a felhasználó adatainak kilistázására szolgál, a felhasználó itt tud jelszót módosítani, illetve kijelentkeznia rendszerből.|
|Felület|K9|Andoid View - Kibérelt Járművek|1.0|A Felhasználó által kibérelt autók kilistázására  szolgál. Megjeleníti a járművet és a bérlés kezdetét és végét.|

## 4. Jelenlegi üzleti folyamatok modellje
---
![Image](https://github.com/PHorvath1/AFP2021/blob/main/Pictures/use_case_model.jpg)

## 5. Igényelt üzleti folyamatok
---
![Image](https://github.com/PHorvath1/AFP2021/blob/main/Pictures/igenyelt_uzleti_folyamat.png)

## 6. Használati esetek
---


## 7. Képernyő tervek
---


## 8. Forgatókönyv
---
István munkaügyben Budapestre utazott, ahol 3 hétig fog egy szállodában lakik. Ez a szálloda Budapest
külvárosában van, a munkája miatt minden nap a belvárosba kell mennie. István elhatározta, hogy a kényelmesebb 
utazás érdekében erre a 3 hétre bérel egy autót. Több járműkölcsönzőbe is elment, de vagy az árak voltak 
magasak, vagy nem is volt olyan jármű, amely megfelelt volna az igényeinek, így ezek a látogatások felesleges 
időpazarlásnak bizonyúltak. Úton a szállása felé hallotta a buszon, hogy egy megbízható, és jó minőségű köl-
csönző megnyitotta mobilszolgáltatását. Letöltötte, megnyitotta, majd az alkalmazás a bejelentkezői 
felületével találkozott. Mivel fiókja nem volt, regisztrálnia kellett. Regisztráció után be tudott jelentkezni,
ekkor az alkalmazás fő oldalára került. István a navigációs menü Kínálat gombjára nyomva és a kívánt kategória 
kiválasztásával kilistázta a kategóriába tartozó járműveket. Talált is egy látszólag megfelelő járművet, de nem
volt biztos benne, hogy az a megfelelő, tehát elolvasta a járműhöz tartozó leírást és most már biztos volt 
abban, hogy az lesz a megfelelő. Megadta a számlázási adatait, majd 2 nap múlva egy óra utazás után kezébe 
adták a kulcsot.

## 9. Fogalomtár
---

