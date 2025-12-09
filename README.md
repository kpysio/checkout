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

- Combine Offer (Apple + Banana Offer)

The CombineOffer applies when an Apple and a Banana are purchased together.
The cheapest item in the pair is free.
