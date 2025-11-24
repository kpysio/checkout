This design is fully SOLID

✔ Single Responsibility

- ItemMaster registers items

- PriceMaster holds prices

- OfferEngine applies offers

Checkout calculates totals

✔ Open/Closed

- Add new items without modifying existing classes

- Add new offers by implementing Offer

✔ Liskov

- All offers follow the same contract

✔ Interface Segregation

- Checkout depends only on interfaces it needs

✔ Dependency Inversion

- Checkout depends on abstractions (Offer, Master classes)