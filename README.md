# Gestiune-comenzi-si-produse
Acest proiect este o aplicație Java care utilizează Java Persistence API (JPA) pentru gestionarea persistenței datelor într-o bază de date PostgreSQL și Vaadin pentru interfața web.

Proiectul este împărțit în două module:

JPA Persistence Module – conține modelul de entități, repository-urile și logica de acces la baza de date.

Vaadin Web Application – oferă o interfață web pentru vizualizarea și gestionarea datelor.

Aplicația simulează gestionarea produselor și comenzilor într-un sistem de tip magazin.

Funcționalități:

-Model orientat obiect format din 10 entități JPA

-Ierarhie de moștenire între entități

-Schema SQL generată automat din modelul de entități

-Operații CRUD prin repository-uri

-Teste JPA pentru generarea tranzacțională de date

-Interfață web Vaadin cu două view-uri:
                                        -vizualizarea datelor (list/grid)
                                        -formular pentru operații CRUD
