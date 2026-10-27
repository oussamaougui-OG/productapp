## Étapes de réalisation

### Étape 1 : Installation d'IntelliJ IDEA Ultimate
Installation de l'IDE IntelliJ IDEA Ultimate, avec un JDK 21 et Git.

### Étape 2 : Création du projet via Spring Initializr
Création du projet `productapp` (groupe `net.oussama`) avec les dépendances **Spring Web**, **Spring Data JPA**, **H2 Database** et **Lombok**.


### Étape 3 : Création de l'entité JPA `Product`
L'entité `Product` possède les attributs suivants :

| Attribut | Type |
|---|---|
| `id` | `Long` |
| `name` | `String` |
| `price` | `double` |
| `quantity` | `int` |

Les annotations Lombok (`@Data`, `@Builder`, `@NoArgsConstructor`, `@AllArgsConstructor`) évitent d'écrire les getters, setters et constructeurs.

![Classe Product](<img width="290" height="302" alt="product" src="https://github.com/user-attachments/assets/131cf9d6-3900-4975-9088-f03794462ab4" />
)

### Étape 4 : Configuration de l'unité de persistance
Dans `application.properties` :
- URL H2 en mémoire : `jdbc:h2:mem:products-db`
- `spring.jpa.hibernate.ddl-auto=create-drop`
- `spring.jpa.show-sql=true`

![application.properties](docs/images/application-properties.png)

### Étape 5 : Création du repository
L'interface `ProductRepository` étend `JpaRepository<Product, Long>` et ajoute deux méthodes de recherche :
- `findByNameContainsIgnoreCase`
- `findByPriceGreaterThan`

Spring Data génère l'implémentation à partir du nom des méthodes.

![ProductRepository](docs/images/product-repository.png)

### Étape 6 : Test des opérations
Un `CommandLineRunner` exécute au démarrage les opérations suivantes :
- ajout de produits
- consultation de tous les produits
- consultation d'un produit par id
- recherche par nom et par prix
- mise à jour d'un produit
- suppression d'un produit

![Console](docs/images/console.png)

## Résultat

La console affiche les trois produits ajoutés, puis l'ordinateur mis à jour (prix 7500, quantité 8), puis la liste après suppression de l'imprimante (id=2). Toutes les opérations CRUD fonctionnent.

## Gestion de versions

Un commit et un push ont été effectués à chaque étape.

![Historique des commits](docs/images/commits.png)

## Conclusion

Ce travail m'a permis de découvrir le mapping objet-relationnel avec JPA et la génération automatique des requêtes par Spring Data.
