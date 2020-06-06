import React from 'react';
import Initiative from "../components/Initiatives/Initiative";

class InitiativeList extends React.Component {
  render() {
    return (
      <div className="InitiativeList mt-4">
        <Initiative title={'Запретить стройку парковки вместо парка отдыха'}
                    content={'На улице парковой хотят построить парковку для бизнес-центра...'}
                    date={'Сегодня'}
                    author={'Елена Иванова'}/>
        <Initiative title={'Проверить аварийное жилье на улице Аварийная д.5'}
                    content={'Мне кажется оно упадет.'}
                    date={'1 день назад'}
                    author={'Иван Иванов'}/>
        <Initiative title={'Построить приют для животных'}
                    content={'Везде гуляют бездомные собаки. Я боюсь гулять по своему району. ' +
                    'Есть люди, которые занимаются отстрелом собак! Прямо на улице! ' +
                    'Предлагаю построить приют для животных. НЕ НАДО УБИ...'}
                    date={'3 дня назад'}
                    author={'Петр Петров'}/>
      </div>
    )
  }
}

export default InitiativeList;