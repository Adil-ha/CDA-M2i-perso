import express from "express";

const app = express();
app.use(express.json());

// Simuler une base de données pour stocker les todos
const todos = [
  {
    id: 1,
    titre: "sport",
    contenu: "Aller à l'entrainement",
    statut: true,
  },
  {
    id: 2,
    titre: "course",
    contenu: "Faire les courses",
    statut: false,
  },
  {
    id: 3,
    titre: "visite",
    contenu: "Visiter les parents",
    statut: true,
  },
  {
    id: 4,
    titre: "travail",
    contenu: "Finir l'application",
    statut: false,
  },
];

//ajouter une todo
app.post("/todos", (req, res) => {
  const { titre, contenu, statut } = req.body;
  const id = Date.now();
  const todo = { id, titre, contenu, statut };
  todos.push(todo);
  res.json(todo);
});

//modifier une todo
app.put("/todos/:id", (req, res) => {
  const id = +req.params.id;
  const { titre, contenu, statut } = req.body;
  const todo = todos.find((todo) => todo.id === id);

  if (!todo) {
    return res.status(404).json({ message: "Todo non trouvée" });
  }

  todo.titre = titre || todo.titre;
  todo.contenu = contenu || todo.contenu;
  todo.statut = statut || todo.statut;

  res.json(todo);
});

// obtenir toute les todos
app.get("/todos", (req, res) => {
  res.json(todos);
});

// obtenir une todo
app.get("/todos/:id", (req, res) => {
  const id = +req.params.id;
  const todo = todos.find((todo) => todo.id === id);

  if (!todo) {
    return res.status(404).json({ code: 404, message: "Todo non trouvée" });
  }

  res.json(todo);
});

// supprimer une todo
app.delete("/todos/:id", (req, res) => {
  const id = +req.params.id;
  const index = todos.findIndex((todo) => todo.id === id);

  if (index === -1) {
    return res.status(404).json({ message: "Todo non trouvée" });
  }

  todos.splice(index, 1);
  res.json({ message: "Todo supprimée avec succès" });
});

// filtrer une todo
app.get("/todos/search", (req, res) => {
  const { titre } = req.query;
  const filteredTodos = todos.filter((todo) => todo.titre.includes(titre));
  res.json(filteredTodos);
});

// modifiez un element d'une todo
app.patch("/todos/:id", (req, res) => {
  const id = +req.params.id;
  const { statut } = req.body;
  const todo = todos.find((todo) => todo.id === id);

  if (!todo) {
    return res.status(404).json({ message: "Todo non trouvée" });
  }

  todo.statut = statut;
  res.json(todo);
});

const port = 3000;
app.listen(port, () => {
  console.log(`Serveur démarré sur le port ${port}`);
});
