require('pg')

class SqlRunner

  def SqlRunner.run(sql, values = [])

    db = PG.connect({dbname: 'pizza_shop', host: 'localhost'})
    db.prepare('query', sql)
    result = db.exec_prepared('query', values)

    db.close()

    return result
  end

end
