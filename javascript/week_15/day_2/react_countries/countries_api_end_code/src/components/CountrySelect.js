import React, { Component } from 'react';

class CountrySelect extends Component {


  constructor(props){
    super(props)
    this.state = {
      value: props.startValue
    }
    this.handleChange = this.handleChange.bind(this)
  }

  handleChange(event){
    this.setState({value: event.target.value})
    this.props.onCountrySelected(event.target.value)
  }

  render() {

    const countryOptions = this.props.countryNames.map((countryName, index) => {
      return <option key={index} value={index}>{countryName}</option>
    })
  

    return (
      <select id="country-select" onChange={this.handleChange} value={this.state.value} >
        <option disabled value={"-1"}>Choose a country...</option>
        {countryOptions}
      </select>
    )
  }

}

export default CountrySelect;
