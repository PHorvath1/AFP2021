## Rendszerterv

## 1. A rendszer célja
---


## 2. Projektterv
---
#### Projektszerepkörök:
Scrum master:
Product Owner:

#### Projektmunkások és felelősségeik:
Frontend munkálatok:
    - Csattos Bence
    - Horváth Krisztián
    - Horváth Péter
A projekt frontend részén dolgozók feladata, hogy az alkalmazáshoz egy felhasználói felületet készítsenek.

Backend munkálatok:
    - Csattos Bence
    - Horváth Krisztián
    - Horváth Péter
A projekt backend területét végzők feladata, hogy szolgáltatást készítsenek, amelyre majd épül az alkalmazás.

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


## 6. Fizikai környezet
---
Fejlesztői környezet:


## 7. Architekturális terv
---
A kliens és a szerver HTTP/HTTPS protokolon keresztül kommunikál egymással.

### Adatbázis:
- A rendzer adatainak tárolásához szükséges egy Adatbázis, a rendszerhez MySql-t alkalmazunk.
### Backend:
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


## 10. Teszt terv
---


## 11. Telepítési terv
---


## 12. Karbantartási terv
---

