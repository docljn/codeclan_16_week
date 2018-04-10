import React from 'react';
import CountrySelect from '../components/CountrySelect';
import CountryDetail from '../components/CountryDetail';

class CountryContainer extends React.Component {
  
  render(){
    return (
      <div>
        <h2>Country Container</h2>
        <CountrySelect />
        <CountryDetail />
      </div>
    );
  }
}

export default CountryContainer;
