## Követelmény Specifikáció

## 1. Áttekintés
---
Az általunk fejlesztett telefonos applikácíó a jármű bérlést hivatott egyszerüsíteni. Az alkalmazás Android operációs renszerrel rendelkező okostelefonokon érhető el. Az Autó kölcsönző kínálata csoportokra van bontva kivitel szerint (Limuzin,SUV,Kombi,Kupé) és az összes gépkocsihoz részletes leírás tartozik(Teljesítmény, Automata/Manuális), a leendő ügyfél ezek közül választhat. Mikor kliensünk sikeresen kiválaszotta, a számára megfelelő járművet, csak annyi dolga van, hogy rá klikkel az autóra, megdaja a számlázási adatait, azt hogy hány napra kivánja kibérelni az autót illetve, hogy hol szeretné átvenni.

## 2. Jelenlegi helyzet
---
Jelenleg az autó kölcsönzés személyesen történik, sok papírmunkával jár, valamint nem kényelmesen intézhető. Az információk helyben derülnek ki, helyszín nem választható, csak a megadott helyen intézhető. Az ügyfelek és a járművek adminisztrációs feladata bonyolult, nehezen átlátható. Az ügyfél nem látja, hogy milyen opciók elérhetőek, csak ha már személyesen ott van. Ez sok ideig tart és az ügyfél nem biztos, hogy talál számára megfelelő járművet.

## 3. Vágyálom rendszer
---
A projekt célja, hogy egy olyan alkalmazást fejlesszünk, ami megkönnyíti a jármű berlési folyamatát. Az alkalmazás Android rendszeren lesz elérhető. A felhasználó az alkalmazás letöltését és megnyitását követően találkozik a felhasználói felülettel. A felhasználói felület egyszerű, letisztult/felhasználóbarát kivitelezésű. A felhasználó egy folyamatosan bővülő kinálatból választhat számára megfelelő járművet, a választás segítése céljából a rendszer tárolni fog minden járműről egy leírást. Az alkalmazás használójának lehetősége van, hogy szűrje a kinálatot, ha már van egy elképzelése a kívánt járműről. Amennyiben a felhasználó megtalálta a számára megfelelő járművet, kitölti a szükséges adatokat akkor egy kis idő elteltével már használatba is veheti a járművet. Továbbá lehetősége lesz értékelés adására, így ha a felhasználó meg volt elégedve a szolgáltatás minőségével, akkor azt jelezheti a készítők és a további felhasználók számára.

## 4. Funkcionális követelmények
---
A alkalmazás a következő funkciókat kell, hogy biztosítsa:
- Járművek listázása
- Jármű adatainak kiírása
- Járművek szűrése
- Bérlési igény elküldése
- Értékelés lehetősége

## 5. Rendszerre vonatkozó törvények, szabványok, ajánlások
---
- A képek .jpg vagy .png kiterjesztésűek lesznek
- GDPR-nak való megfelelés

## 6. Jelenlegi üzleti folyamatok modellje
---
![Image](https://github.com/PHorvath1/AFP2021/blob/main/Pictures/use_case_model.jpg)

## 7. Igényelt üzleti folyamatok
---
![Image](https://github.com/PHorvath1/AFP2021/blob/main/Pictures/igenyelt_uzleti_folyamat.png)

## 8. Követelménylista
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


## 9. Riportok
---
Kérdeőív az járműbérlő alkalmazás fejlesztéséhez

Kérem, hogy a sikeres fejlesztés érdekében a legjobb tudomása szerint válaszoljon az alábbi kérdésekre.
Amennyiben kérdése van, nyugodtan tegye fel a kérdező biztosnak. Együttműködését előre is köszönjük!

1. Milyen előnyöket nyújt Ön szerint az járműbérlő alkalmazás?

    Egy ilyen alkalmazással elérhetőbbé válik az autóbérlő szolgáltatásunk. Ez alatt azt értem, hogy vásárlóink
    nem csak a szomszédos falvakból, városokból, hanem akár szomszédos megyékből is eljöhetnek. Továbbá mivel 
    ezzel az alkalmazással a vásárlók a teljes kínálatot megtekinthetik, így már az érkezésük előtt 
    eldönthetik, hogy melyik járművet szeretnék bérbe venni.

2. Milyen funkciókat vár el ettől az alkalmazástól?

    Mindenképp szeretném látni a kínálatot, csoportokra bontva. Egy termékünkre nyomva kiírja annak adatait.
    Továbbá kell, hogy legyen egy adat kitöltő űrlap, melyet kitöltve és elküldve valamilyen visszajelzést kap
    a vásárló. Végül szeretném, hogy lehetőség legyen felhasználói fiókok létrehozására, melyek további
    szolgáltatásokat nyújtanak.

3. Milyen további funkciókat látna szívesen az alkalmazásban?

    Jó lenne, ha lehetőség lenne termékek csoportokra bontott megjelenítésén kívül további szűrők állnának
    rendelkezésre, például: név, évjárat. Illetve, szívesen látnám, ha lenne lehetőség a járműbérlő alkalmazást
    értékelni, mert így a cégünk is és a vásárlók is láthatnánk a visszajelzéseket.

## 10. Fogalomtár
---
* **Android**: A mobiltelefonokon lévő operációs rendszer.
* **GDPR**: Európai Unió által kiadott rendelet, amely a személyes adatok kezeléséről szól. 
