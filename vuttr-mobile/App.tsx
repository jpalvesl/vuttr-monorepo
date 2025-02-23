import Item from 'components/Item';
import SearchBox from 'components/SearchBox';
import { StatusBar } from 'expo-status-bar';
import { SafeAreaView, ScrollView } from 'react-native';
import './global.css';
import instance from 'service/api';
import { useEffect, useState } from 'react';

export default function App() {
  const [lista, setLista] = useState([]);

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
        <SearchBox />

        <ScrollView showsVerticalScrollIndicator={false} className="mb-2">
          {lista.map((item) => (
            <Item key={item.id} item={item} />
          ))}
        </ScrollView>
      </SafeAreaView>
    </>
  );
}
