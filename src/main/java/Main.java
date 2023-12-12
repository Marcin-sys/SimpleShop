import basket.factory.ShoppingJourney;


/*Rozbudowa aplikacji sklep. Zamiana tablic na kolekcje, zapis danych do pliku.
Wymyślcie sposób na to aby wszystkie dane były zapisywane do jednego pliku
(chcemy mieć jeden plik bd.txt, w którym są użytkownicy, produkty i wszystko co macie w aplikacji).
Dodajcie opcję rejestracji użytkowników - jak aplikacja się uruchamia to pokazuje się wybór
czy chcesz się zalogować czy zarejestrować. Jeśli ktoś wybierze logowanie to pojawia
się mechanizm do logowania i aplikacja działa po staremu. Jeśli użytkownik wybierze
rejestrację to aplikacja wypytuje o login i hasło i rejestruje nowego użytkownika.
Potem wraca do początku i znowu pyta czy chcesz się zalogować czy zarejestrować.
Aplikacja powinna sprawdzać czy ktoś nie wpisał loginu który już istnieje,
jeśli tak to pyta ponownie o dane rejestracji. Admin ma nową funkcję -
może zmienić jakiegoś USERa na ADMINa. ADMIN podaje login i ten user staje się adminem
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome");
        new ShoppingJourney().shopManagerMenu();
        System.out.println("End of shopping. See you again");

    }
}
