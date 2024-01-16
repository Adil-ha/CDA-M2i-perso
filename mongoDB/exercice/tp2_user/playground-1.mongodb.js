use("tpdeux");
// db.users.find();

// db.users.insertOne({name:"Chuck Norris",
//                      age : 77,
//                     hobbies:["Karate","Kung-fu","Ruling the world"]});

//  db.users.find();

//db.users.find({ name: "Chuck Norris" });

// db.users.findOne({ "name": "Chuck Norris" }, { "_id": 0 })

// db.users.find({ age: { $gte: 20, $lte: 25 } });

//db.users.find({ "gender": "male", "age": { $gte: 30, $lte: 40 } })

//db.users.find({ "address.state": "Louisiana" })

//db.users.find().sort({ "age": -1 }).limit(20)

//db.users.count({ "gender": "female", "age": 30 })

//db.users.updateMany({}, { $unset: { "phone": 1 } })

//db.users.updateOne({ "name": "Chuck Norris" }, { $set: { "age": Infinity } })

//db.users.updateMany({ "age": { $gt: 50 } }, { $push: { "hobbies": "jardinage" } })
