const numbers = [1, 2, 3, 4, 5];

// 1. write a function called `multiplyByTwo`
// that returns a new array with each element of the original array multiplied by 2

// const multiplyByTwo = function(numbersArray) {
//   const result = [];
//
//   numbersArray.forEach(function(number){
//     const multipled = number * 2;
//     result.push(multipled);
//   });
//
//   return result;
// }


const multiplyByTwo = function(numbersArray) {

  const transformedArray = numbersArray.map(function(number){
    return number * 2;
  })

  return transformedArray;
}

console.log(multiplyByTwo(numbers));



// 2. write a function called `getEvens`
//that returns a new array with all the even numbers from the original array

// const getEvens = function(numbersArray){
//   const result = []
//
//   numbersArray.forEach(function(number, index){
//     if ( number % 2 === 0 ) {
//       result.push(numbers)
//     }
//   })
//
//   return result;
// }

// console.log(getEvens(numbers));


const getEvens = function(numbersArray){

  const filteredArray = numbersArray.filter(function(number){
    return number % 2 === 0;
  });

  return filteredArray;
}

console.log(getEvens(numbers));


// 3. write a function called `sumElements`
//that returns the sum total of all the elements of the original array

// const sumElements = function(numbersArray){
//
//   let total = 0;
//
//   numbersArray.forEach(function(number){
//     total += number;
//   })
//
//   return total;
// }

const sumElements = function(numbersArray) {

  const total = numbersArray.reduce(function(runningTotal, number){
    return runningTotal + number;
  }, 0)

  return total;

}


console.log(sumElements(numbers))
