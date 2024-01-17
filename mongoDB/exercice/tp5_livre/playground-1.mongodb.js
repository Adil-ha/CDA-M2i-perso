use("tpCinq");
// db.livres.find();

// db.livres.aggregate([
//   { $match: { authors: "Toru Ishida" } },
//   { $sort: { booktitle: 1, "pages.start": 1 } },
// ]);

// db.livres.aggregate([
//     { $match: { "authors": "Toru Ishida" } },
//     { $project: { "_id": 0, "title": 1, "pages": 1 } },
//     { $sort: { "booktitle": 1, "pages.start": 1 } }
// ])

// db.livres.aggregate([
//     { $match: { "authors": "Toru Ishida" } },
//     { $count: "totalPublications" }
// ])

// db.livres.aggregate([
//     { $match: { "year": { $gte: 2011 } } },
//     { $count: "totalPublicationsSince2011" },
//     { $group: { _id: "$type", count: { $sum: 1 } } }
// ])

db.livres.aggregate([
  { $unwind: "$authors" },
  { $group: { _id: "$authors", count: { $sum: 1 } } },
  { $sort: { count: -1 } },
]);
