const btnAddProduct = document.querySelector(".btnAddProduct");
const listProduct = [];
let id = 0;
const containListProduct = document.querySelector(".product-list-container");
const reset = document.querySelector(".reset");

window.addEventListener("load", () => {
  const localstoragetab = JSON.parse(localStorage.getItem("product"));
  console.log(localstoragetab);
  if (localstoragetab) {
    //Cela permet de fusionner les produits chargés depuis le local storage avec les produits existants dans la mémoire de l'application.
    listProduct.push(...localstoragetab);
    console.log(listProduct);
    createProductInTable();
  }
});

btnAddProduct.addEventListener("click", () => {
  const productInput = document.querySelector(".productInput").value;
  if (productInput != "") {
    id = new Date().getTime().toString();
    const product = {
      id: id,
      name: productInput,
    };
    listProduct.push(product);
    const tabproduct = JSON.stringify(listProduct);
    localStorage.setItem("product", tabproduct);
    document.querySelector(".productInput").value = "";
    createProductInTable();
  } else {
    alert("le champs est vide!");
  }
});

reset.addEventListener("click", () => {
  localStorage.clear();
  location.reload();
});

function createProductInTable() {
  containListProduct.innerHTML = "";
  listProduct.forEach((currentProduct) => {
    const ul = document.createElement("ul");
    ul.setAttribute("data-id", currentProduct.id);
    const li = document.createElement("li");
    li.innerHTML = currentProduct.name;

    const editButton = document.createElement("button");
    editButton.innerHTML = "Éditer";
    editButton.className = "btn btn-primary btn-sm mr-2";
    editButton.addEventListener("click", () => {
      alert("Fonction d'édition non implémentée.");
    });

    const deleteButton = document.createElement("button");
    deleteButton.innerHTML = "Supprimer";
    deleteButton.className = "btn btn-danger btn-sm";
    deleteButton.addEventListener("click", () => {
      const productId = currentProduct.id;
      deleteProductById(productId);
    });

    ul.appendChild(li);
    ul.appendChild(editButton);
    ul.appendChild(deleteButton);
    containListProduct.appendChild(ul);
  });
}

function deleteProductById(id) {
  const index = listProduct.findIndex((product) => product.id === id);
  if (index !== -1) {
    listProduct.splice(index, 1);
    localStorage.setItem("product", JSON.stringify(listProduct));
    const productElement = document.querySelector(`[data-id="${id}"]`);
    if (productElement) {
      productElement.remove();
    }
  }
}

// function editProductById(id, newName) {
//   const index = listProduct.findIndex((product) => product.id === id);
//   if (index !== -1) {
//     listProduct[index].name = newName;
//     localStorage.setItem("product", JSON.stringify(listProduct));
//     const productElement = document.querySelector(`[data-id="${id}"]`);
//     if (productElement) {
//       const li = productElement.querySelector("li");
//       li.innerHTML = newName;
//     }
//   }
// }
