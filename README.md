
## Opis Programu

Program ma odbierac i zapisywac dane lokalizacji urzadzenia GPS.

Postanowilem zaimplementowac to w sposob asynchroniczny przez uzycie adnotacji 
@Async na metodzie zapisujacej dane do bazy danych dzieki temu operacja ta nie blokuje watka
ktory ja wywowal i pozwala mu wrocic a sama metoda pracuje na innym watku przez co ilosc
aktywnych watkow jest zmniejszona.

Dodalem rowniez obsluge wyjatkow od Hibernate Validator ktora zwraca json z opisem bledu.


Chyba mozliwe jest stworzenie wlasnej metody save w CrudRepository ktora zwraca Future<Location> przez to bedziemy mogli 
zwrocic zapisany objekt ale nie jestem pewien jak to bedzie dzialac.