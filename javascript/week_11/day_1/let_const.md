## `let` & `const`

Up until now we've been using the `var` keyword to declare variables. ES6 (also known as ES2015) introduced two different keywords that we can use instead. These keywords are `let` and `const`.

Variables declared using these keywords differ from variables declared using `var` in the way that they behave, including the way that they are scoped.

Variables that are declared using `var`, as we just learned, are function scopes, whereas variables declared using `let` or `const` are block scoped.

Let's consider the following code snippet:

```js
var canIDrive = function (age) {
  if (age >= 17) {
    var message = 'You can learn to drive!';
  }
  else {
    var message = "You're too young. Sorry!";
  }

  console.log('The message is:', message);
}

canIDrive(21);
```

This works because the variable `message` was declared with `var`, therefore can be referenced anywhere within the function.

## `let`

If we were to replace the `var` keywords with `let` then we would encounter a ReferenceError.

```js
var canIDrive = function (age) {
  if (age >= 17) {
    let message = 'You can learn to drive!'; // UPDATED
  }
  else {
    let message = "You're too young. Sorry!"; // UPDATED
  }

  console.log('The message is:', message);
}

canIDrive(21);
```

`message` is not defined because variables that were declared using `let` are block scoped. They cannot be referenced from outside of the enclosing block attached to the `if` statement.

Instead we have to declare the variable `message` outside of the block, before we assign a value to it.

```js
var canIDrive = function (age) {
  let message; // NEW
  
  if (age >= 17) {
    message = 'You can learn to drive!'; // UPDATED
  }
  else {
    message = "You're too young. Sorry!"; // UPDATED
  }

  console.log('The message is:', message);
}

canIDrive(21);
```

### `const`
Variables that are declared using `const` are also block scoped but in contrast to `let`, variables declared using `const` cannot be reassigned or declared again within the same scope.

```js
var canIDrive = function (age) {
  const message; // UPDATED
  
// -> TypeError: Assignment to constant variable.
```

Why would we want to do this? This prevents us from being able to change the values of our variables!

This can actually be useful more often than you'd think. If we  know that the values of our variables can't change then we can eliminate a lof of unexpected behaviours from our applications.

> Note: While variables declared using `const` cannot be reassigned, they can be mutated. You can call `push()` and `pop()` on an array that was declared using `const`, for example.

It's best practice to default to using `const` when declaring variables. If you need to be able to change the value of a variable then you should use `let` instead. `var` doesn't really have a place in modern JavaScript code bases.

It is important, however, to understand how `var` works as it's still commonly used in older code bases, or applications that want to target older browsers which don't support newer JavaScript features such as `let` and `const`.
