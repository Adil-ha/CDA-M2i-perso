use("book");

// update

//db.books.updateOne({_id: 45}, {$set: {status : "CANCELED", pageCount : 6000}});

//db.books.updateMany({_id: {$in:[55,75]}},{$set:{status: "CANCELED"}});

//db.books.updateOne({_id: 45}, {$inc: {pageCount: 15000}});
//db.books.find({_id: 45});

//supprime les autheurs
//db.books.updateOne({_id: 45}, {$unset:{authors:[]}})

//db.books.updateOne({_id:45},{$rename: {status:"position"}});
db.books.find({ _id: 45 });
