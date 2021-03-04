## Backend és Adatbázis Futtatása
  - A Backend és Adatbázis Futtatásához szükség van a Docker Desktop-ra, 
  amely az alábbi linken elérhető:"https://docs.docker.com/docker-for-windows/install/"
  - Sikeres telepítés után Parancssorból/Terminálból, futtatni kell a "docker-compose.yml" nevü fájlt
  amely a Projekt könyvtárban az alábbi útvonalon található "/Backend/docker-compose.yml"
  - A Futtatáshoz az alábbi parancsot kell használni:"docker-compose up"
  - Sikeres futtatás után a Backend  a "localhost:8000" porton,
  az Adatbázis pedig  a "localhost:6033 porton érhető el."

### Fejlesztés InteliJ-ben
- Inteli J-ben való PHP fejlesztéshez szükséges a PHP plugin, amely telepíthető a
  Beállítások/Plugins menüpont alatt. A JetBrain által fejlesztett Plugin-t érdemes választani.
  
### Csatlakozás az adatbázishoz Fejlesztői környezetből. (InteliJ IDEA Ultimate)
 - Shift dupla lenyomása után, egy kereső ablak jelenik meg, írjuk be a "Database" kulcsszót. 
   Vagy kattintsuk a Database menüpontra, amely a fejlesztői környezet 
   jobb felső sarkában a kereső alatt található.
 - A Database ablakon belül adjuk hozzá az adatbázist a projektünkhöz a Plusz jel segítségével. 
   Válasszuk ki a "Datasource -> MySql " Opciót, majd töltsük ki az alábbi mezőket.
   
   - Port: 6033
   - Host: localhost
   - User: devuser
   - Password: devpass
   - Database: rental_db
    
- Driver telepítése szükséges, de az InteliJ automatikusan figyelmeztet. 
  Test Connection lenyomsásával tesztelhetjük a kapcsolatot.
  
- Sikeres csatlakozás után mentsük el a konfigurációt.

### SQL Parancsok futtatása InteliJ-ben
- Sikeres adatbázis kapcsolódás után, a kapcsolatra jobb klikkelve meg tudjuk nyitni
  az adatbázis consol-t, ahol parancsokat adhatunk az adatbázis számára.

<image src="https://github.com/PHorvath1/AFP2021/blob/main/Pictures/InteliJSetup/InteliJDatabaseSetup.png" width="50%" />




  
  

