const arrayTasks = {

  concat: function (arr1, arr2) {
    return arr1.concat(arr2)
  },

  insertAt: function (arr, itemToAdd, index) {
    arr.splice(index, 0, itemToAdd)
    return arr
  },

  square: function (arr) {
    return arr.map(function (number) {
      return number ** 2
    })
  },

  sum: function (arr) {
    return arr.reduce(function (total, number) {
      return total + number
    })
  },

  removeAndClone: function (arr, valueToRemove) {
    return arr.filter(function (number) {
      return number !== valueToRemove
    })
  },

  findIndexesOf: function (arr, itemToFind) {
    return arr.reduce(function (newArray, number, index) {
      return number === itemToFind ? newArray.concat(index) : newArray
    }, [])
  },

  sumOfAllEvenNumbersSquared: function (arr) {
    return arr.reduce(function (sum, number) {
      return number % 2 === 0 ? sum + number ** 2 : sum
    }, 0)
  },

  // ----------- EXTENSION ------------

  findDuplicates: function (arr) {
    
    // This commented-out solution works too
    //
    // return arr.reduce(function(newArray, number, index, startArray){

    //   const isDuplicated = startArray.filter(startNumber => startNumber === number).length > 1
    //   return isDuplicated && !newArray.includes(number) ? newArray.concat(number) : newArray

    // }, [])
    
    const counts = {}
    return arr.filter(function (item) {
      if (!counts[item]) {
        counts[item] = 1
      } else {
        counts[item] += 1
        if (counts[item] === 2) return true
      }
    })

  }
}

module.exports = arrayTasks
