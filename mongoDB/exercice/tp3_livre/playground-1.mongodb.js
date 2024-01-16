use("bibliotheque");
db.livre.find();

// db.livre.find({ "type": "Book" })

// db.livre.find({ "year": { $gte: 2011 } })

// db.livre.find({ "type": "Book", "year": { $gte: 2014 } })

// db.livre.find({ "authors": "Toru Ishida" })

// db.livre.distinct("publisher", { "type": "publisher" })
