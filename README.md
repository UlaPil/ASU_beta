# ASU_beta
Autorzy: Anna Krzaczkowska grupa zajęciowa: 2 Szymon Trofimiec grupa zajęciowa: 3 Urszula Pilśniak grupa zajęciowa: 2

Opis Projektu: Naszym projektem będzie gra karciana oparta na Uno.

Przebieg gry: Każdy gracz ma początkowo po siedem losowo dobranych kart, wygrywa ten, który pierwszy odda je wszystkie na stół. W swoim ruchu można wyrzucić maksymalnie jedną kartę. Są trzy rodzaje kart: zwykłe, wpływające na drugiego gracza oraz wpływające na grę. Jeśli na stole jest karta zwykła, możemy dorzucić dowolną kartę, która musi być dopasowana do poprzedniej kolorem lub cyfrą. Są cztery karty funkcyjne: “+2”, “+4 (zmiana koloru)”, “blokada” oraz “zmiana koloru”. Po rzuceniu karty zmiany koloru, gracz rzucający wybiera kolor, który musi rzucić następny gracz. Jeśli poprzedni gracz rzucił kartę “+2” lub “+4”, drugi gracz dobiera odpowiednio dwie lub cztery karty i nie może rzucić już nic na stół, chyba że ma w ręce taką samą kartę w dowolnym kolorze, to wtedy może ją rzucić i nie dobierać. Wartości dobieranych kart sumują się od momentu pierwszej “+2” lub “+4” w serii. Jeśli poprzedni gracz rzucił kartę “blokada”, drugi gracz traci kolejkę. Jeśli graczowi została w ręce ostatnia karta, musi kliknąć przycisk “ASU”. Drugi gracz może go uprzedzić klikając “STOP ASU”, wtedy gracz z ostatnią kartą dobiera cztery karty.

Nasz program będzie implementował grę w ASU w dwie osoby, w szczególności:

Funkcjonalności podstawowe: Klasę Card, która zawiera podstawowe funkcjonalności każdej karty, karty specjalne będą tworzone za pomocą kompozycji Klasę Board, która przechowuje informacje o aktualnym stanie gry ( kolor i cyfra ostatniej zagranej karty, informacje o tym czyja jest tura, oraz 2 sterty kart: jedna do zagrywania kart, druga do dobierania. Klasę Player która przechowuje informacje o graczu, w tym: ile i jakie karty ma, oraz udostępnia metody play i draw: play : metoda komunikuje się z board, i zagrywa kartę i wywołuje jej efekty, jeśli to możliwe draw : gracz dobiera karty.

Funkcjonalności opcjonalne : Możliwość gry z robotem Menu główne i opcje Możliwość reagowania emotikonami z przeciwnikiem

Biblioteki/Framework JavaFX
