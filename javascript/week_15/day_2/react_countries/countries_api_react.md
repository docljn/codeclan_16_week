# React Countries

## Learning Objectives

- Be able to make HTTP requests to fetch data inside a React component
- Further practice passing around data between React components

## Intro

You all wrote awesome applications using the countries RESTful API in vanilla JS. In this lesson we are going to use React to make a HTTP request to the same API. As we saw with the Comments app, by setting the received data on our state, we trigger a re-render of our application, which we can use to populate our UI. Here we will see how React's component lifecycle methods can help us perform HTTP requests. We will also be using stateless functional components where possible.

## Design

We are going to build an app that makes a request to the countries API, populates a drop-down select with the names of the countries, and allows the user to select a country and see more details about the selected country. Let's think about which components we might need to make this, and what state and props each would require.

> Discuss design and get to a structure that looks something this.

- CountryContainer: state: countries, selectedCountryIndex
- CountrySelect: state: value, props - countryNames, handleChange
- CountryDetail: props - country

## 

## Implementation

Let's start by creating a React project with Create React App:

```bash
create-react-app countries
```

> Instructor note: Hand out the `src` folder from `countries_api_start` and get students to drop it into their own React app. Then ask the class...

1. What containers/components do we already have in the start code?
2. What props and state does each they have?

<details>
<summary>Answers:</summary>
1. `CountryContainer`, `CountrySelect`, `CountryDetail`
2. None of the components or containers have props or state
</details>

<br>

Let's look at our `CountryContainer`, which will be our main parent component. This should control the state of our application. Let's set up the initial state of the Container so that it has an empty list of countries and a focus country which will start as null.

```js
// CountryContainer.js
  constructor(props){
    super(props);
    this.state = { // CHANGED
      countries: [],
      selectedCountryIndex: null
    };
  }
```

We have rendered this in our `App` top-level component.

> Task (2 minutes): Ask students how they might check that this change has occured - prompt to use React Dev tools to check that `countries` and`selectedCountryIndex` have been added to the state of `CountriesContainer`

## Getting Countries from API

We're going to use one of the lifecycle methods to perform our HTTP request to the API, `componentDidMount`. This method will be triggered when the component has successfully been rendered into the DOM. The React documentation recommends that this is the right place to do HTTP requests.

> [Task]: Make a request to the REST Countries API and pass them to the component's state when loaded.

```js
//CountryContainer.js

  componentDidMount() {
    const url = 'https://restcountries.eu/rest/v2/all';
    const request = new XMLHttpRequest();
    request.open('GET', url);

    request.addEventListener("load", () => {
      if (request.status !== 200) return;
      const jsonString = request.responseText;
      const countriesObjects = JSON.parse(jsonString);
      this.setState({countries: countriesObjects})
    });

    request.send();
  }
```

Again we can check dev tools and see that the state has changed!

## Creating a select

Now we can start adding to our other components. Let's have a look at our countries select dropdown - currently there is no information in it.

Inspecting the `CountrySelect` component with the React Dev tools, we can see that it doesn't have any props.  What properties would we like this to have? The list of countries names. A `select` only needs to know the text it should hold in each `option`. So we'll need to map our country objects into country names.

```js
// CountryContainer.js

render(){

  const countryNames = this.state.countries.map(country => country.name)

  return(
    <div>
      <h2>Country Container</h2>
      <CountrySelect
        countryNames={countryNames} />
      <CountryDetail />
    </div>
  );
}
```

The `CountrySelect` component now has access to the array of country names, so let's set it up to use that data to populate the `select` with `option` elements displaying these names.

> Ask the students how we would go about this, if they seem confident get them to have a go themselves.

We can create a new array of populated option tags by calling `map` on the array of country objects we passed in through props.

```js
class CountrySelect extends Component {

  constructor(props){
    super(props)
  }

  render(){

     const options = this.props.countryNames.map((countryName, index) => {
      return <option value={index} key={index}>{countryName}</option>
    })

   
    return <select id="country-select">
      <option disabled>Choose a country...</option>
      {options}
    </select>
  }
}
```

## Handling Select `onChange()`

We'll write a function within our stateless component to handle a change in the `<select>` box. For now, all it will do is log the value. Then we add an `onChange` attribute to the `select`:

```js
// CountrySelect.js
class CountrySelect extends Component {

  constructor(props){
    super(props)
  }

  handleChange(event) {
    console.log(event.target.value);
  }

  render(){

     const options = this.props.countryNames.map((countryName, index) => {
      return <option value={index} key={index} onChange={this.handleChange}>{countryName}</option>
    })

   
    return <select id="country-select">
      <option disabled>Choose a country...</option>
      {options}
    </select>
  }
}
```

## Passing the callback via props

Now we have access to the index of the selected country in the countries array. But we only have access to this index in the `CountrySelect` component. We want to have access to it at the top level, in the `CountryContainer`, so that we can use it to set the state of the current country, and cause a re-render of the `CountryDetail`. Let's do this with a function that is defined in the `CountryContainer` and passed as a prop to the `CountrySelect`. The function is going to take in the index and set it on the `CountryContainer`'s state.

```js
// CountryContainer.js

handleCountrySelected(index) {
  this.setState({selectedCountryIndex: index})
}
```

REMEMBER to bind it in the `CountryContainer` `constructor` method:

```js
// CountryContainer.js
constructor(props){
  // ...
  this.handleCountrySelected = this.handleCountrySelected.bind(this);
}
```

...and pass that function to `CountrySelect` as a prop:

```js
render(){
  return (
    {/* ... */}
    <CountrySelect
      countries={this.state.countries}
      onCountrySelected={this.handleCountrySelected}/>
    {/* ... */}
  );
}
```

Back in our `CountrySelect` component, we can pass the value of the `select` into this function as the `index`:

```js
// CountrySelect.js

handleChange(event) {
  this.props.onCountrySelected(event.target.value);
}
```

REMEMBER to bind it in the `CountrySelect` `constructor` method:

```js
// CountrySelect.js
constructor(props){
  // ...
  this.handleChange = this.handleChange.bind(this);
}
```

We can now use the React dev tools to check that the state in the `CountryContainer` is updating with the current country.

## CountryDetail Display

Now that we have a selector that is updating the selected country, the final piece in the puzzle is our detailed display.

When the user selects a country, we want the details of the selected country to be displayed. The `CountryDetail` component is going to be responsible for this.

So how are we going to do render these details? Now that we have a selector that is updating the `selectedCountryIndex` in `CountryContainer`'s state, we can pass down to `CountryDetail` as a prop drilling down into the countries array with the index.

```js
// CountryContainer.js

const selectedCountry = this.state.countries[this.state.selectedCountryIndex]
...
<CountryDetail country={ selectedCountry } />
```

Now we have access to the currently selected `country` in the `CountryDetail` component, we can get it to render its various properties.

```js
// CountryDetail.js

const CountryDetail = (props) => {
  return (
    <h3>{props.country.name}</h3>
  );
}
```

The first time the CountryDetail component is rendered, the HTTP request won't have been made yet and no country will have been selected by the user, so `props.country` will be `undefined`. If we ask an `undefined` object for the property `name`, we will get an error in the browser. To avoid this, we will put in a guard to return out of the function and not render anything if `props.country` is falsy.

```js
// CountryDetail.js

const CountryDetail = (props) => {
  if (!props.country) return null; // UPDATED
  return (
    <h3>{props.country.name}</h3>
  );
}
```

## Task: (5 minutes)

Render some more of the country's properties in the `CountryDisplay` component.

<details>
<summary>Example solution</summary>

```js
const CountryDetail = (props) => {
  if (!props.country) return null;
  return (
    <h3>{props.country.name}</h3>
    <p>Capital: {props.country.capital}</p>
    <p>Population: {props.country.population}</p>
  );
}
```
</details>

## Recap

> Task (10 minutes): Write down the order in which the `render` and `componentDidMount` methods are being called as the components are created and the user interacts with them. Take note of the state and props of each component at each stage.

<details>
<summary>Answer:</summary>

* Initial `render()` is called:
  * `CountryContainer` state: `{ countries: [], selectedCountryIndex: null }`
  * `CountrySelect` props: `{ countryNames: [], onCountrySelected: CountryContainer.handleCountrySelected} }`
  * `CountryDetail` props: `{ country: null }`

* `componentDidMount()` is called and makes the request:
  * `CountryContainer` state: `{ countries: [ country objects ], selectedCountryIndex: null }`

* `render()` is called again by state change:
  * `CountrySelect` props: `{ countryNames: [ country names ], onCountrySelected: CountryContainer.handleCountrySelected} }`

* User selects a country:
  * `CountryContainer` state: `{ countries: [country objects], selectedCountryIndex: { index of selected country } }`

* `render()` is called again by state change:
  * `CountryDetail` props: `{ country: { country object } }`

</details>

<br>

## Conclusion

We can now build a multi component React app, and hook into a React component's lifecycle methods to make an HTTP request and update its own state, triggering re-rendering of the UI on the completion of the request using the `setState` method.

## Bonus explanation of end code - AKA turning CountrySelect into a controlled component

As we saw in the comments lesson, form elements inherently have some state. In the case of a select it's the currently selected option. We're used to reading this in JavaScript by getting the `value` of the select which corresponds to the value set on the selected option.

```js
document.getElementsById('country-select').value`
```

We perhaps also know we can set `selected` on an option. So have seen something like -

`<option selected value="4">Armenia</option>`

But the 'React way' with a controlled component is to set an aptly name `value` attribute.

```js
//  CountrySelect.js
 <select id="country-select" onChange={this.handleChange} value={this.state.value} >
 ```

 We need to set up a default state in our constructor 

 ```js
//  CountrySelect.js
 constructor(props){
    super(props)
    this.state = {
      value: props.startValue
    }
  }
```

And pass this through from out `CountryContainer`

```js
// CountryContainer.js
<CountrySelect countryNames={countryNames} onCountrySelected={this.handleCountrySelected} startValue={"-1"} />
```

(startValue has been chosed to avoid confusion with `defaultValue` - an attribute we can set on uncontrolled components...*sound of heads exploding*)

We also need to update `this.state.value` when our `onChange` event occurs

```js
// CountryContainer.js
 handleChange(event){
    this.setState({value: event.target.value})
```

And don't forget to bind in the constructor -

```js
// CountryContainer.js
this.handleChange = this.handleChange.bind(this)
```

Finally we can set the value of our 'header' option to make it be selected by default -

```js
// CountryContainer.js
<option disabled value={"-1"}>Choose a country...</option>
```

# Phew!
