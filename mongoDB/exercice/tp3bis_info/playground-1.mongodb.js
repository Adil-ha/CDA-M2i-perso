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

// db.products.find();

// db.products.findOne();

// let thinkpadId = db.products.findOne({ nom: "Thinkpad X230" })._id;
// db.products.findOne({ _id: thinkpadId });

//db.products.find({ "prix": { $gt: 13723 } })

//db.products.findOne({ "ultrabook": true })

// db.products.findOne({ "nom":{$regex:"Macbook", $options:"i"}})

// db.products.find({ "nom":{$regex:"^Macbook", $options:"i"}})
//  db.products.find({ "nom": /^Macbook/i })

// db.products.deleteMany({ "fabriquant": "Apple" })

// db.products.deleteOne({ "_id": ObjectId("65a69e6f14b5d209f96d4259") })

// db.products.find();
