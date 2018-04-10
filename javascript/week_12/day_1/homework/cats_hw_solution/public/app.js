const CAT_DATA = [
  {
    name:"Boba",
    favFood: "Sock fluff",
    img: "http://66.media.tumblr.com/d1f01bbe0150fda0c40d2151c5eaeac8/tumblr_odlqqskjj61v9cejwo1_400.jpg"
  },
  {
    name:"Barnaby",
    favFood: "Tuna",
    img: "http://65.media.tumblr.com/8a827e13ebb5db7d16e2b1c4cbe7ce70/tumblr_odtp4ftIhB1uhevdso1_400.jpg"
  },
  {
    name:"Max",
    favFood: "Whiskas Temptations",
    img: "http://66.media.tumblr.com/7c5784ea89369c780e782bf10c60315a/tumblr_npb0hlYwhV1u63jaco1_1280.jpg"
  },
  {
    name:"Chloe",
    favFood: "Salmon",
    img: "http://66.media.tumblr.com/857fb2f1f93e0b34de45a86a09c9a8e5/tumblr_o1s3aq3XVi1u63jaco1_1280.jpg"
  }
];

const app = function() {
  CAT_DATA.forEach(function(cat) {
    addCat(cat.name, cat.favFood, cat.img);
  });
};

const addCat = function(name, favFood, imgUrl) {
  const catContainer = createUl();
  const nameElement = createLi("Name", name);
  const favFoodElement = createLi("Favourite food", favFood);
  const imgElement = createImg(imgUrl);

  const cats = document.querySelector('#cats');
  appendElements(cats, catContainer, nameElement, favFoodElement, imgElement);
};

const createUl = function() {
  const ul = document.createElement('ul');
  ul.classList.add('cat');
  return ul;
};

const createLi = function(label, text) {
  const li = document.createElement('li');
  li.innerText = label + ": " + text;
  return li;
};


const createImg = function(url) {
  const img = document.createElement('img');
  const li = document.createElement('li');
  img.width = "500";
  img.src = url;
  li.appendChild(img);
  return li;
};

const appendElements = function(cats, catContainer, name, favFood, img) {
  catContainer.appendChild(name);
  catContainer.appendChild(favFood);
  catContainer.appendChild(img);

  cats.appendChild(catContainer);
};

document.addEventListener('DOMContentLoaded', app);
