// we have no native enums so this is a workaround
// take this as one solution, not the ideal solution
// not sure how 'JavaScripty' it is. But demonstrates one way of mapping
// from a readable naming structure to a number
// so taskEnum.DIFFICULTY.MEDIUM === 1
// 
// helps with sorting tasks (see hero.js)

const taskEnum = {
  DIFFICULTY: {
    EASY: 0,
    MEDIUM: 1,
    HARD: 2
  },
  URGENCY: {
    LOW: 0,
    MEDIUM: 1,
    HIGH: 2
  }
}

module.exports = taskEnum;
