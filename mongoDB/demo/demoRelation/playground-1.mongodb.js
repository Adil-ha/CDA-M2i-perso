use("demoRelation")

//db.user.insertOne({_id: "123", nom: "Michel", email: "michel@gmail.com", profil: { age: 30, hobbies: ["Peinture","Sport"]}})
//db.user.find()
// 65a7da8db8a15db7f28af7d2
//db.user.insertOne({_id: "124", nom: "Paul", email: "paul@gmail.com", profil_Id: ObjectId("65a7da8db8a15db7f28af7d2")})
//db.profil.insertOne({age: 55, hobbies: ["Echec","Football"]})
//db.profil.find()
//db.user.find()

/* db.profil.aggregate([
    {$lookup : {from: "user", localField: "_id", foreignField: "profil_Id", as: "user"}},
    {$match : {_id: ObjectId("65a7da8db8a15db7f28af7d2")}}]) */
