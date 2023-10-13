class Car {
  constructor(title, description, price, picture = null) {
    this.id = new Date().getTime();
    this.title = title;
    this.description = description;
    this.price = price;
    this.picture = picture;
  }
}
export default Car;
