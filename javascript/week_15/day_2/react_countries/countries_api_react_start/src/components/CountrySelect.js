import React, { Component } from 'react';

class CountrySelect extends Component {

  render() {
    return (
      <select id="country-select" >
        <option disabled>Choose a country...</option>
      </select>
    )
  }

}

export default CountrySelect;
