use("hopital");
// db.patient.insertMany([
//   {
//     firstname: "Mohamed",
//     lastname: "Deloin",
//     age: 38,
//     history: [
//       { desease: "rhume", treatment: "sirop" },
//       {
//         desease: "grippe",
//         treatment: "anti-biotique",
//       },
//     ],
//   },
//   {
//     firstname: "Michel",
//     lastname: "Dupont",
//     age: 55,
//     history: [
//       { desease: "rhume", treatment: "sirop" },
//       {
//         desease: "grippe",
//         treatment: "anti-biotique",
//       },
//     ],
//   },
//   {
//     firstname: "Damien",
//     lastname: "Petit",
//     age: 15,
//     history: [
//       { desease: "rhume", treatment: "sirop" },
//       {
//         desease: "grippe",
//         treatment: "anti-biotique",
//       },
//     ],
//   },

// ]);

// db.patient.find();

//db.patient.updateOne({_id:ObjectId("65a6650fb8cb41284e6656ca")},{$set:{age:42,lastname:"Detresloin",history:[{desease: "gastro"}]}})
// db.patient.find({_id:ObjectId('65a6650fb8cb41284e6656ca')})

// db.patient.find({age: {$gte: 29}});

// db.patient.deleteMany({
//     "history": {
//       $elemMatch: {
//         "desease": "rhume"
//       }
//     }
//   })
db.patient.find();
