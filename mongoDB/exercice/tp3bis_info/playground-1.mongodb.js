use("info");
// db.products.insertMany([
//   {
//     nom: "MacBook Pro",
//     fabriquant: "Apple",
//     prix: 11435.99,
//     options: ["Intel Core i5", "Retina Display", "Long life battery"],
//   },
//   {
//     nom: "MacBook Air",
//     fabriquant: "Apple",
//     prix: 125794.73,
//     options: ["Intel Core i7", "SSD", "Long life battery"],
//   },
//   {
//     nom: "Thinkpad X230",
//     fabriquant: "Lenovo",
//     prix: 114358.74,
//     options: ["Intel Core i5", "SSD", "Long life battery"],
//   },
// ]);

//db.products.find();

// db.products.findOne();

var thinkpadId = db.produits.findOne({ nom: "Thinkpad X230" })._id;
db.products.findOne({ _id: thinkpadId });
