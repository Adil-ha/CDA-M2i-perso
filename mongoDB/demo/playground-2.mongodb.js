//use("book");
//db.books.find();

// recherche id 45
//db.books.find({_id:45});

// limiter à 5
//db.books.find().limit(5);

//avec 2 auteurs
//db.books.find({authors: {$size:2}});

//nombre de pages egal a 400 et plus
//db.books.find({pageCount: {$gte: 400}});

// id == 55, 75 et 120
//db.books.find({_id: {$in: [55,75,120]}});

//avec 2 auteurs, tri par titre et puis _id
//db.books.find({authors : {$size: 2}})
//.sort({title: 1, _id:1});

//avec 2 auteurs, saute les 10 premiers(skip) tri par titre et puis _id
//db.books.find({authors : {$size: 2}})
//.skip(10)
//.sort({title: 1, _id:1});

//intervalle id entre 26 et 49
//db.books.find({$and: [{_id: {$gt:25}},{_id: {$lt: 50}}]}).count();

//projection
//affiche id a partir de 46 et les auteurs
//db.books.find({_id: {$gt: 45}},{_id:1, authors:1});

//affiche tout sauf le tableau d'auteur à partir de l'id 46
//db.books.find({_id: {$gt: 45}},{authors:0});

//compris dans le tableau
//db.books.find({categories: {$in : ["Java", 'Web Development']}});

//les deux informations
//db.books.find({categories : {all : ["Java", 'Web Development']}});

//l'un ou l'autre
//db.books.find({$or: [{_id: 19},{_id : 89}]});

//commence par ext ou EXT
//db.books.find({longDescription : {$regex: "^ext", $options: "i"}});

//le titre termine par perl
//db.books.find({title : {$regex: "Perl$", $options: "i"}});
