import Item from 'components/Item';
import SearchBox from 'components/SearchBox';
import { StatusBar } from 'expo-status-bar';
import { SafeAreaView, ScrollView } from 'react-native';
import './global.css';
import instance from 'service/api';
import { useEffect, useState } from 'react';

export default function App() {
  const [text, setText] = useState('');
  const [lista, setLista] = useState([]);

  async function onSearch() {
    try {
      const { data } = await instance.get('1');
      console.log(data);
      setLista([data]);
    } catch (error) {
      console.error(error);
    }
  }

  useEffect(() => {
    (async (async) => {
      try {
        const { data } = await instance.get('');
        setLista(data);
        console.log(lista);
      } catch (error) {
        console.error(error);
      }
    })();
  }, []);

  return (
    <>
      <StatusBar style="light" />
      <SafeAreaView className="flex-1 bg-gray-800 pl-4 pr-4 pt-10">
        <SearchBox text={text} setText={setText} onSearch={onSearch} />

        <ScrollView showsVerticalScrollIndicator={false} className="mb-2">
          {lista.map((item) => (
            <Item key={item.id} item={item} />
          ))}
        </ScrollView>
      </SafeAreaView>
    </>
  );
}
