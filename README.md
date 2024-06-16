# ASU_beta
Autorzy:\
Anna Krzaczkowska grupa zajęciowa:\
2 Szymon Trofimiec grupa zajęciowa: 3\
Urszula Pilśniak grupa zajęciowa: 2\

Opis Projektu: Naszym projektem jest gra karciana inspirowana "UNO"

Przebieg gry: Każdy gracz ma początkowo po siedem losowo dobranych kart, wygrywa ten, który pierwszy wystawi je wszystkie na stół. W swoim ruchu można zagrać maksymalnie jedną kartę. Karty mogą być zwykłe lub specjalne. Jeśli na stole jest karta zwykła, możemy dorzucić dowolną kartę, która musi być dopasowana do poprzedniej kolorem lub cyfrą. Są cztery karty specjalne: “+2”, “+4 (zmiana koloru)”, “blokada” oraz “zmiana koloru”. Po zagraniu karty zmiany koloru, gracz zagrywający wybiera kolor, który musi rzucić następny gracz. Jeśli poprzedni gracz zagrał kartę “+2” lub “+4”, drugi gracz dobiera odpowiednio dwie lub cztery karty i nie może rzucić już nic na stół, chyba że posiada taką samą kartę w dowolnym kolorze, to wtedy może ją rzucić i nie dobierać. Wartości dobieranych kart sumują się od momentu pierwszej “+2” lub “+4” w serii. Jeśli poprzedni gracz zagrał kartę “blokada”, drugi gracz traci kolejkę. 

Nasza aplikacja będzie implementowała grę w ASU single-player ( z trzema robotami)

Funkcjonalności które udało się dodac:
-
- Estetyczny ekran Menu zawierający 2 przyciski : "Game" i "History" oraz customowy przycisk wyjscia z aplikacji
- W pełni funkcjonalną grę w uno zawierającą wszystkie karty dostępne w oryginalnej wersji gry,
- Możliwość wyswietlania historii rozgrywki

Informacje:
-
- W historii znajdują się 2 rozgrywki zagrane przez nas aby pokazać, jak wygląda historia. Aby zresetowac historie wystarczy usunac plik *src/main/resources/history.txt*. Przy zagraniu kolejnej gry plik utworzy się automatycznie.
- Podczas rozgrywki po tym jak bot zagra karte blokujaca/ sprawiajaca ze gracz dobiera, w przypadku bycia celem tej karty należy nacisnąć na stos do dobierania aby kontynuować rozgrywkę.





Biblioteki/Framework JavaFX


Dziekujemy za uwage i życzymy wspaniałej rozgrywki w ASU.

