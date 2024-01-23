use("restaurant");
// db.restaurants.find();

// db.restaurants.aggregate([{ $limit: 10 }]);
// db.restaurants.find().limit(10);

// db.restaurants.aggregate([
//     { $sort: { name: 1 } },
//     { $limit: 10 }
// ])
// db.restaurants.find().sort({ name: 1 }).limit(10)

// db.restaurants.aggregate([
//     { $match: { borough: "Brooklyn" } },
//     { $sort: { name: 1 } },
//     { $limit: 10 }
// ])

// db.restaurants.aggregate([
//     { $project: { _id: 0, name: 1, borough: 1 } },
//     { $limit: 10 }
// ])

// db.restaurants.aggregate([
//     { $project: { address: 0, grades: 0 } },
//     { $limit: 10 }
// ])

// db.restaurants.aggregate([
//     { $project: { name: 1, borough: 1, num_grades: { $size: "$grades" } } },
//     { $limit: 10 }
// ])

// db.restaurants.aggregate([
//     { $project: { name: 1, borough: 1, num_grades: { $size: "$grades" } } },
//     { $sort: { num_grades: -1 } },
//     { $limit: 10 }
// ])

// db.restaurants.aggregate([
//     { $project: { _id: 0, upper_name: { $toUpper: "$name" }, borough: 1 } },
//     { $limit: 10 }
// ])

// db.restaurants.aggregate([
//     { $project: { _id: 0, upper_name: { $toUpper: "$name" }, first_three_letters: { $substr: ["$borough", 0, 3] } } },
//     { $limit: 10 }
// ])

// db.restaurants.aggregate([
//   { $group: { _id: null, total_restaurants: { $sum: 1 } } },
// ]);

// db.restaurants.aggregate([
//     { $group: { _id: "$borough", total_restaurants: { $sum: 1 } } }
// ])
