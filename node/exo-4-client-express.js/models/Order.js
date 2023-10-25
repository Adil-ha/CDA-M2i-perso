export class Order {
  constructor(id, customer, product) {
    (this.id = id), (this.customer = customer);
    this.product = product || [];
  }
}
