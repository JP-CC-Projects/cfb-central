// MyLoading.tsx
interface LoadingProps {
    message?: string;
  }
  
  const MyLoading: React.FC<LoadingProps> = ({ message = 'Loading...' }) => {
    return (
      <div className="loading-container">
        <div className="spinner"></div>
        <p>{message}</p>
      </div>
    );
  };
  
  export default MyLoading;
  